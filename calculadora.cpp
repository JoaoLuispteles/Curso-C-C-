#include <stdio.h>

int main(){
	char operacao;
	float n1,n2,resultado;
	
	printf("Digite a operação (+, -, *, /, %): ");
	scanf("%c", &operacao);
	
	printf("Digite o primeiro numero: ");
	scanf("%f", &n1);
	
	printf("Digite o segundo numero: ");
	scanf("%f", &n2);
	
	switch(operacao){
		case '+':
			resultado = n1+n2;
			printf("Resultado: %.2f", resultado);
			break;
		case '-':
			resultado = n1-n2;
			printf("Resultado: %.2f", resultado);
			break;
		case '*':
			resultado = n1*n2;
			printf("Resultado: %.2f", resultado);
			break;
		case '/':
			if(n2!= 0){
			resultado = n1/n2;	
			printf("Resultado: %.2f", resultado);			
			}else{
				printf("Erro: Divisão por 0");
			}
			break;
		case '%':
			resultado =(int)n1 % (int)n2;
			printf("resultado: %.2f", resultado);
			break;
		default:
			printf("Operação invalida");
	}
	return 0;
}
