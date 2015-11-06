#ponto
class Ponto(object):
	"""Classe para reprenter um ponto"""
	x=0
	y=0
	
class Retangulo(object):
	"""Um retangulo"""
	largura = 0
	altura = 0
	origem = Ponto()
	
	def area(self):
		print "Area eh %d" % (self.largura*self.altura)
		
	def move(self, sentido, passos):
		if sentido == "h":
			self.origem.x += passos
		else:
			self.origem.y += passos
	
	def pos(self):
		print "Origem (%d, %d)" % (self.origem.x, self.origem.y)