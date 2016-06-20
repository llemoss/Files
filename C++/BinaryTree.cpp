#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <math.h>

using namespace std;

class No{
	public:
		int info;
		No *left;
		No *right;
		No (int n){
			info = n;
			left = NULL;
			right = NULL;
		}
};

class Tree{
	public:
		
		No *root;
		No *resultadoPai;
		No *resultado;
		
		int h;
		int qtd;
		
		Tree(){
			root = NULL;
			resultado = NULL;
			resultadoPai = NULL;
			h = -1;
			qtd = 0;
		}
		
		int isComplete(){
			getHeight();
			return (getQtd() == maxQtd());
		}
		
		int isEmpty(){
			return (root == NULL);
		}
		
		int maxQtd(){
			return (pow(2, h+1) - 1);
		}
		
		int getQtd(){
			if(isEmpty() != 1){
				qtd++;
				calculateQtd(this->root);
			}
			return qtd;
		}
		
		void calculateQtd(No *no){
			if(no != NULL){
				if(no->left != NULL){
					qtd++;
					calculateQtd(no->left);
				}
				if(no->right != NULL){
					qtd++;
					calculateQtd(no->right);
				}
			}
		}
		
		int getHeight(){
			if(isEmpty() != 1){
				h = calHeight(this->root);
			}
			return h;
			
		}
		
		int greater(int a, int b){
			return (a > b ? a : b);
		}
		
		int calHeight(No *no){
			if(no == NULL || (no->left == NULL && no->right == NULL)){
				return 0;	
			}else{
				return 1 + greater(calHeight(no->left), calHeight(no->right));
			}
		}
		
		void calculateHeight(No *no){
			if(no != NULL){
				if((no->left != NULL) && (no->right != NULL)){
					h++;
					calculateHeight(no->left);
					calculateHeight(no->right);
				}else{
					if(no->right != NULL){
						h++;
						calculateHeight(no->right);
					}
					if(no->left != NULL){
						h++;
						calculateHeight(no->left);
					}	
				}
				
			}
		}
		
		void newBranch(int n, int side, int where){
			No *input = new No(n);
			insert(root, input, where, side);
		}
			
		void freeBranch(No *input){
			
			No *temp;
			
			if(input->left == NULL && input->right == NULL){
				cout << "Freed - " << input->info << endl;
				free(input);
			}else{
				
				if(input->left != NULL){
					temp = input->left;
					freeBranch(temp);
				}
				
				if(input->right != NULL){
					temp = input->right;
					freeBranch(temp);
				}
				
				cout << "Freed - " << input->info << endl;
				
				if(input->info == root->info){
					root = NULL;
				}
				
				free(input);
			}
		}
		
		No *freeOrd(No *parent, int info){
			No *temp;
			if(isEmpty() != 1){
				if(root->info == info){
					freeBranch(root);
				}else{
					if(info < parent->info){
						temp = parent->left; 
						cout << "Trying to free: " << parent->left->info << endl;
						parent->left = NULL;
						freeBranch(temp);
					}else{
						temp = parent->right; 
						cout << "Trying to free: " << parent->right->info << endl;
						parent->right = NULL;
						freeBranch(temp);
					}	
				}
			}
		}
		
		void freeSon(No *parent, int info){
			
			if(isEmpty() != 1){
				if(root->info == info){
					freeBranch(root);
				}else{
					if(parent->right != NULL){
						if(parent->right->info == info){
							No *temp = parent->right; 
							cout << "Trying to free: " << parent->right->info << endl;
							parent->right = NULL;
							freeBranch(temp);
						}
					}
					
					if(parent->left != NULL){
						if(parent->left->info == info){
							No *temp = parent->left; 
							cout << "Trying to free: " << parent->left->info << endl;
							parent->left = NULL;
							freeBranch(temp);
						}
					}	
				}
			}
		}
		
		void newInsert(No *parent, No *input){
			if(isEmpty() == 1){
				root = input;
			}else{;
				if(parent != NULL){ 
					
					if(parent->info < input->info){
						cout << "Novo eh maior que a raiz (Root: " << parent->info << ")" << endl;
						cout << "Valor: " << input->info << endl;
						if(parent->right == NULL){
							parent->right = input;
						}else{
							newInsert(parent->right, input);
						}
					}else if(parent->info > input->info){
						cout << "Novo eh menor que a raiz (Root: " << parent->info << ")" << endl;
						cout << "Valor: " << input->info << endl;
						
						if(parent->left == NULL){
							parent->left = input;
						}else{
							newInsert(parent->left, input);
						}
					}
					
					return;
				}
			}
		}
		
		void insert(No *parent, No *input, int where, int side){
			if(isEmpty() == 0){
				if(parent != NULL){
					if (parent->info == where){
						if (side == 1){
							if(parent->left == NULL){
								parent->left = input;
							}
						}else if(side == 2){
							if(parent->right == NULL){
								parent->right = input;
							}
						}
					}else{
						insert(parent->left, input, where, side);
						insert(parent->right, input, where, side);
					}
				}
			}else{
				root = input;
			}
		}
		
		void showTree(){
			if(root == NULL){
				cout << "\nEmpty" << endl;
			}else{
				cout << endl;
				showBranch("<", root);
				cout << endl;
			}
		}
		
		void showBranch(char msg[30], No *tree){
			if(tree != NULL){
				cout << msg << tree->info;
				showBranch("<", tree->left);
				showBranch("<", tree->right);
				cout << ">";
			}else{
				cout << "<>";
			}
		}
		
		No *searchParent(No *r, int info){ //procuraPai
			No *parent = NULL; //No *pai
			if(r != NULL){
				if(r->left != NULL && r->left->info == info){
					return r;
				}else if(r->right != NULL && r->right->info == info){
					return r;
				}else{
					if(info > r->info){
						return searchParent(r->right, info);
					}else{
						return searchParent(r->left, info);
					}
				}
			}
		}
		
		No *searchFilho(No *r, int branch){
			No *result = NULL;
			if(r != NULL){
				if(r->left != NULL && r->left->info == branch){
					return r->left;
				} else if (r->right != NULL && r->right->info == branch){
					return r->right;
				} 
			}
		}
		
		void search(No *root, int item){
			
			if(root->left != NULL && root->left->info == item){
				resultadoPai = root;
				resultado = root->left;
				cout << "Found: " << resultado->info << endl;
				cout << "Parent: " << resultadoPai->info << endl;
			}else if(root->right != NULL && root->right->info == item){
				resultadoPai = root;
				resultado = root->right;
				cout << "Found: " << resultado->info << endl;
				cout << "Parent: " << resultadoPai->info << endl;
			}else{
				
				cout << "Searching... - Current: " << root->info << endl;
				
				if(root->right != NULL){
					search(root->right, item);
				}
				
				if(root->left != NULL){
					search(root->left, item);
				}
			}
		}
		
};

int main(){
	Tree *tree = new Tree();
	
	// tree->newBranch(1, 1, NULL);
	// tree->newBranch(2, 1, 1);
	// tree->newBranch(3, 2, 1);
	// tree->newBranch(4, 1, 2);
	// tree->newBranch(5, 2, 2);
	// 
	tree->newInsert(tree->root, new No(6));
	tree->newInsert(tree->root, new No(2));
    tree->newInsert(tree->root, new No(8));
    tree->newInsert(tree->root, new No(1));
    tree->newInsert(tree->root, new No(4));
    tree->newInsert(tree->root, new No(3));
	tree->showTree();
	
	cout << "\n";
	
	cout << "Altura: " << tree->calHeight(tree->root) << endl << endl;
	
	No *pai = tree->searchParent(tree->root, 2);
	
	cout << "Pai: " << pai->info << endl;
	cout << "Filho: " << tree->searchFilho(pai, 2)->info << endl;
	
	// tree->search(tree->root, 3);
	// tree->freeSon(tree->resultadoPai, 3);
	// 
	// tree->showTree();
	// 
	// tree->search(tree->root, 2);
	// tree->freeSon(tree->resultadoPai, 2);
	// 
	// tree->showTree();
	// 
	// tree->search(tree->root, 5);
	// tree->freeSon(tree->resultadoPai, 5);
	// 
	// tree->showTree();
	
	return 0;
}