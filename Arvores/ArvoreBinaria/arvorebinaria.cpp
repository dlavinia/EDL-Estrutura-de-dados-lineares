#include <iostream>
#include <vector>
#include<algorithm>

using namespace std;

template <typename T>
class node{
    private:
        T  ch;
        node * pai;
        node * filhoDireito_;
        node * filhoEsquerdo_;

    public:
        node(node * pai, T o){
            this-> ch = o;
            this-> pai = pai;
            this->filhoDireito_ = NULL;
            this->filhoEsquerdo_ = NULL;
        }
        node * get_filho_esquerdo(){
            return this->filhoEsquerdo_;
        }
        node * get_filho_direito(){
            return this->filhoDireito_;
        }
        node * get_pai(){
            return this->pai;
        }

        T get_chave(){
            return this->ch;
        }

        bool is_internal(){
            return this->get_filho_esquerdo() != NULL || this->get_filho_direito()!=NULL;
        }
        bool is_external(){
            return this->get_filho_esquerdo() == NULL && this->get_filho_direito()==NULL;
        }
       
        void set_pai(node* p){
            this->pai = p;
        }
        void set_filho_esquerdo(node* fe){
            this->filhoEsquerdo_ = fe;
        }
        void set_filho_direito(node* fd){
            this->filhoDireito_ = fd;
        }
        //teste
        void print_filhos(){
            int fD = this->get_filho_direito()->get_chave();
            int fE = this->get_filho_esquerdo()->get_chave();
            cout << "Filhos de " << this->get_chave() << endl;
            cout << "Filho Esquerdo: " << fE << endl;
            cout << "Filho Direito: " << fD << endl;
            cout << endl;
           
           
        }
};

template <typename T>
class arvore_b{
    private:
        node<T> *root_;
        unsigned int size_;
   
    int altura_(node<T> * no){
    if (no -> is_external()) return 0;
    else{
    int altura = 0;
    if(no->get_filho_esquerdo() != NULL)
        altura = max(altura, altura_(no->get_filho_esquerdo()));

    if(no->get_filho_direito() != NULL)
        altura = max(altura, altura_(no->get_filho_direito()));

    return altura+1;
    }
}
    public:
    arvore_b(T ch){
        root_ = new node<T> (NULL, ch);
    }
      node<T> * root(){
        return this->root_;
    }

    node<T> *pesquisar(T k, node<T> * v){
        if(v->is_external()){
            return v;
        }
        if (k < v->get_chave()){
            return this->pesquisar(k, v->get_filho_esquerdo());
        }
        else if(k = v->get_chave()){
            return v;
        }
        else{
            return this->pesquisar(k, v->get_filho_direito());
        }
    }
   
    node<T> * incluir(T k){
        node<T> * pai = pesquisar(k, root());
        node<T> * novo = new node<T>(pai, k);
        
    if(k < pai->get_chave() ) pai->set_filho_esquerdo(novo);
    
    else pai->set_filho_direito(novo);
    
    return novo;
    }

    int altura(){
        return this->altura_(root_);
}

 
};

template <typename T>
void test(){
    arvore_b<T> a1(10);  
    node<T> * raiz = a1.root();
    int chave = a1.root()-> get_chave();
   
    node<T> * testep = a1.pesquisar(14, a1.root());
    T result = testep->get_chave();

    T resut = testep->get_chave();
   
   
 
    node<T> * f1 = a1.incluir(7);
   
    node<T> * f2 = a1.incluir(12);
    raiz->print_filhos();
   
    node<T> * f3 = a1.incluir(2);
   
    node<T> * f4 = a1.incluir(8);
   
    T filhoEs =  raiz->get_filho_esquerdo()->get_chave();
    T filhoDir =  raiz->get_filho_direito()->get_chave();
   
    T paif3 = f3->get_pai()->get_chave();
   
    raiz->print_filhos();
    f1->print_filhos();
   
   
   // cout << "ponteiro raiz: " << raiz << endl;
    //cout << "Chave raiz: " << chave << endl;
    //cout << "teste pesquisa: " << resut << endl;
    cout << "filho esquerdo de 7: " << f1->get_filho_esquerdo()->get_chave() << endl;
    //cout << "filho direito: " << filhoDir << endl;
    //cout << "ponteiro F3: " << f3 << endl;
   // cout << "pai de F3: " << paif3 << endl;
   
   cout << "Altura: " << a1.altura();
   
}


int main() {
   
   	test<int>();
	return 0;
}
