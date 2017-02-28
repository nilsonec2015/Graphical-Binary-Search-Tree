package modelo;

import interfaces.InterfaceArvore;

/**
 *
 * @author nilso
 */
public class Abb {

    public static No raiz;
    private static int alturaEsq = 0;
    private static int alturaDir = 0;
    private InterfaceArvore comandos;

    public Abb() {
    }

    public Abb(InterfaceArvore comandos) {
        this.comandos = comandos;
    }

    int findHeight(No aNode) {
        if (aNode == null) {
            return -1;
        }

        int lefth = findHeight(aNode.noEsq);
        int righth = findHeight(aNode.noDir);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    //no add
    /*
    se na esquerda e na direita do no eh nulo, aumento a altura
     */
//    public int getAltura() {
//        if (alturaEsq >= alturaDir) {
//            return this.alturaEsq;
//        } else {
//            return this.alturaDir;
//        }
//    }
    public int getAltura() {
        return Math.abs(alturaDir - alturaEsq);
    }

    public int getAlturaDir() {
        return this.alturaDir;
    }

    public int getAlturaEsq() {
        return this.alturaEsq;
    }

    /*INSERÇÃO
    ÁRVORE VAZIA: se ainda não existir nenhum nó na arvore, o primeiro nó
        inserido é considerado "a raiz".
    
    RELAÇÃO DE PAIS E FILHOS: Cada no guarda um valor e tem um link para 
        outro no à esquerda e um link para outro nó à direita. 
        Cada nó linkado é considerado filho do nó que contém o link.
    
    INSERINDO VALORES
        Os valores que forem sendo inseridos devem seguir uma ordem começando
        pelo valor contido na raiz:
        Valores menores, vão para os filhos à esquerda e valores maiores vão
        para os filhos à direita
        
     */
    //versão simplificada usada fora da classe
    public void inserir(int valor) {

        inserir(raiz, valor);

    }

    //versão completa usada internamente
    private void inserir(No no, int valor) {
        //altura parcial
        int altura = 0;
        if (no == null) {
            System.out.println("Inserindo " + valor + " na RAIZ da arvore");
            raiz = new No(valor, 1, 0);
            comandos.desenhar(raiz);
        } else if (valor < no.valor) {//ramo da esquerda
            if (no.noEsq == null) {
                System.out.println("Inserindo " + valor + " na esquerda de " + no.valor);

                //incrementaAltura(valor);
                //no.noEsq = new No(valor, no.altura + 1);
                if (valor > raiz.valor) {
                    alturaDir++;
                    no.noEsq = new No(valor, no.altura + 1, 1);
                } else {
                    alturaEsq--;
                    no.noEsq = new No(valor, no.altura + 1, -2);
                }
                comandos.desenhar(no.noEsq);

            } else {
                inserir(no.noEsq, valor);
            }

        } else if (valor > no.valor) {//ramo da direita
            if (no.noDir == null) {//

                System.out.println("Inserindo " + valor + " na direita de " + no.valor);

                //incrementaAltura(valor);
                if (valor > raiz.valor) {
                    alturaDir++;
                    no.noDir = new No(valor, no.altura + 1, 2);
                } else {
                    alturaEsq--;
                    no.noDir = new No(valor, no.altura + 1, -1);
                }
                //no.noDir = new No(valor, no.altura + 1);
                comandos.desenhar(no.noDir);

            } else {
                inserir(no.noDir, valor);
            }
        } else {
            System.out.println("O valor " + valor + " já está na árvore");
        }

    }

    private void incrementaAltura(int valor) {
        if (valor > raiz.valor) {
            alturaDir++;
        } else {
            alturaEsq--;
        }
    }

    /*
    IMPRESSOES
    PRE-ORDEM: Imprime a raiz e segue imprimindo todas as ramificações à esquerda
        e em seguida as ramificações à direita de cada no.
    
    POS-ORDEM: Imprime começando do no da esqurda de maior nivel da arvore
        (lá em baixo de tudo), passa pelo da direita e sobe para o pai, 
        segue esta ordem ate chegar na raiz.
    
    EM-ORDEM: A ordem de impressao é bagunçada, mas o intuito é mostrar os 
        valores dos nós em ordem crescente, seguindo a principal função de 
        uma árvore. Ou seja, o jeito q insere, eh o jeito q imprime:
        -Imprime primeiro o no da esquerda de maior nivel 
        (lá em baixo (o que guarda o menor valor)), depois imprime o pai, depois
        imprime à direita do pai, depois segue pro "avô", fazendo assim até 
        chegar na raiz.      
    
     */
    public void preordem() {
        preordem(raiz);
    }

    private static void preordem(No no) {
        if (no != null) {
            System.out.print(no.valor + ", ");
            preordem(no.noEsq);
            preordem(no.noDir);
        }
    }

    public void posordem() {
        posordem(raiz);
    }

    private static void posordem(No no) {
        if (no != null) {
            posordem(no.noEsq);
            posordem(no.noDir);
            System.out.print(no.valor + ", ");
        }
    }

    public void emordem() {
        emordem(raiz);
    }

    private static void emordem(No no) {
        if (no != null) {
            emordem(no.noEsq);
            System.out.print(no.valor + ", ");
            emordem(no.noDir);
        }
    }

    /*REMOCAO
    Remover um valor da árvore é um problema, pois, como a árvore segue uma 
        ordem, caso se remova um valor no meio da árvore a ordem é quebrada e a 
        árvore fica inválida. Portanto há três técnicas para remoção de valores
        sem que a órdem seja quebrada:
    
    REMOVENDO NÓS SEM FILHOS (FOLHAS):
        Este é o caso mais simples. apagar nós sem filhos não influencia na 
        órdem da árvore, portanto pode-se apenas apagá-los.
    
    REMOVENDO NÓS COM APENAS UM FILHO:
        Para remover um nó com apenas um filho, basta substituí-lo pelo seu filho
    REMOVENDO NÓS COM DOIS FILHOS:       
        Lembrando da lógica de uma parvore onde, à esquerda temos valores menores
        e à direita valores maiores, dá para se concluir que há duas maneiras
        de se remover um nó com dois filhos.
        -Substituindo o nó pelo descendente à esqurda com o MAIOR valor
            ou
        -Substituindo o nó pelo descendente à direita com o MENOR valor
    
        Deve-se usar apenas uma das duas opções
    
     */
    //versão simplificada usada fora da classe
    public void remover(int valor) {

        raiz = remover(raiz, valor);

    }

    //versão completa usada internamente
    private static No remover(No no, int valor) {
        //caso esteja tentando remover um valor que nao existe
        if (no == null) {
            System.out.println("O valor " + valor + " valor não existe na árvore");
            return null;
        }
        //caso nao seja o valor ainda
        if (valor < no.valor) {//procurando o valor na esquerda
            no.noEsq = remover(no.noEsq, valor);
            return no;
        } else if (valor > no.valor) {//procurando o valor na direita
            no.noDir = remover(no.noDir, valor);
            return no;
        } //caso tenha encontrado o valor
        else //if(valor == no.valor)
        //tratando a remocao
        {
            if (no.noEsq == null && no.noDir == null) {//no folha
                //no lugar do no eu retorno nulo (apago o no)
                return null;
            } else if (no.noEsq != null && no.noDir == null) {//No com um filho na esquerda
                //troco o no pelo seu filho a esquerda
                return no.noEsq;
            } else if (no.noEsq == null && no.noDir != null) {//No com um filho na direita
                //troco o no pelo seu filho a direita
                return no.noDir;
            } else {//No com dois filhos if(no.noEsq != null && no.noDir != null)

                //alvo eh o no que vou excluir
                No alvo = no;
                //pai eh o primeiro no antes do no que ira substitui-lo
                No pai = no;
                //no vira o no que ira substituir o alvo da exclusao
                //(vou procurar o menor valor a direita do alvo para substituir)
                no = no.noDir;
                //o menor valor eh aquele a esquerda que nao tem filhos
                while (no.noEsq != null && no.noDir != null) {
                    //enquanto nao encontro o menor valor, vou atualizando
                    //pai vira o no atual a ser analizado e o no atual passa pro
                    //proximo
                    pai = no;
                    no = no.noEsq;
                }
                //ao encontrar o no folha, 
                // transfiro os filhos da esquerda do no q vou apagar para ele
                no.noEsq = alvo.noEsq;
                //removo ele do link do seu pai
                pai.noEsq = null;
                //se o pai eh o alvo, nao preciso fazer nada no outro link
                if (pai != alvo) {
                    no.noDir = alvo.noDir;
                }

                //retorno este no para o pai dele
                return no;
            }
        }
    }
}
