public class sort{

		public void sort3(int a, int b, int c, boolean reverse){

			int lista [] = {a, b, c};
    
			int d = 0;
		
			while(d<2){
				for(int i = 0;i < 2;i++){
					if (reverse==false){
						if (lista[i] > lista[i+1]){
							int holder = lista[i+1];
							lista[i+1] = lista[i];
							lista[i] = holder;
						}
					}
					else{
						if (lista[i] < lista[i+1]){
							int holder = lista[i+1];
							lista[i+1] = lista[i];
							lista[i] = holder;
						}
					}
				}
				d++;}

			return lista;
		}
	}