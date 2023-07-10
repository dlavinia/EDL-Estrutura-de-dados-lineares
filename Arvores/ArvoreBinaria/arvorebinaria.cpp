#include <iostream>
#include <vector>
#include <algorithm>
#include <bits/stdc++.h>

using namespace std;

template <typename T>
class node
{
private:
    T ch;
    node *pai;
    node *filhoDireito_;
    node *filhoEsquerdo_;

public:
    node(node *pai, T o)
    {
        this->ch = o;
        this->pai = pai;
        this->filhoDireito_ = NULL;
        this->filhoEsquerdo_ = NULL;
    }
    node *get_filho_esquerdo()
    {
        return this->filhoEsquerdo_;
    }
    node *get_filho_direito()
    {
        return this->filhoDireito_;
    }
    node *get_pai()
    {
        return this->pai;
    }

    T get_chave()
    {
        return this->ch;
    }

    bool is_internal()
    {
        return this->get_filho_esquerdo() != NULL || this->get_filho_direito() != NULL;
    }
    bool is_external()
    {
        return this->get_filho_esquerdo() == NULL && this->get_filho_direito() == NULL;
    }

    void set_pai(node *p)
    {
        this->pai = p;
    }
    void set_filho_esquerdo(node *fe)
    {
        this->filhoEsquerdo_ = fe;
    }
    void set_filho_direito(node *fd)
    {
        this->filhoDireito_ = fd;
    }
    void set_chave(T ch)
    {
        this->ch = ch;
    }

};

template <typename T>
class arvore_b
{
private:
    node<T> *root_;
    unsigned int size_;

    int altura_(node<T> *no)
    {
        if (no->is_external())
            return 0;
        else
        {
            int altura = 0;
            if (no->get_filho_esquerdo() != NULL)
                altura = max(altura, altura_(no->get_filho_esquerdo()));

            if (no->get_filho_direito() != NULL)
                altura = max(altura, altura_(no->get_filho_direito()));

            return altura + 1;
        }
    }

    int profundidade_rec(node<T> *no) {
        if (no == this->root()) {
            return 0;
        } 
        else {
            return 1 + this->profundidade_rec(no->get_pai());
        }
    }

    vector<node<T>*> nos_emordem_rec(vector<node<T>*> & nos, node<T>* v ){
        if (v->is_internal())
            if( v->get_filho_esquerdo() != NULL)
                this->nos_emordem_rec(nos, v->get_filho_esquerdo());
        
        nos.push_back(v);

        
        if (v->is_internal())
            if(v->get_filho_direito() != NULL )
                this->nos_emordem_rec(nos, v->get_filho_direito());
        
        return nos;    
    }
    vector<node<T>*> nos_pre_ordem_rec(vector<node<T>*> & nos, node<T>* v ){
            nos.push_back(v);
                 
            if (v->is_internal())
                if( v->get_filho_esquerdo() != NULL)
                    this->nos_pre_ordem_rec(nos, v->get_filho_esquerdo());
            
            if (v->is_internal())
                if(v->get_filho_direito() != NULL )
                    this->nos_pre_ordem_rec(nos, v->get_filho_direito());
            
            return nos;    
    }
    vector<node<T>*> nos_pos_ordem_rec(vector<node<T>*> & nos, node<T>* v ){
            if (v->is_internal())
                if( v->get_filho_esquerdo() != NULL)
                    this->nos_pos_ordem_rec(nos, v->get_filho_esquerdo());
            
            if (v->is_internal())
                if(v->get_filho_direito() != NULL )
                    this->nos_pos_ordem_rec(nos, v->get_filho_direito());
            nos.push_back(v);
            return nos;    
    }
    
    
public:
    arvore_b(T ch)
    {
        root_ = new node<T>(NULL, ch);
    }
    node<T> *root()
    {
        return this->root_;
    }

    node<T> *pesquisar(T k, node<T> *v)
    {
        if (v->is_external() || k == v->get_chave())
        {
            return v;
        }
        if (k < v->get_chave())
        {
            if (v->get_filho_esquerdo() != NULL)
                return this->pesquisar(k, v->get_filho_esquerdo());

            else
                return v;
        }
        else
        {
            if (v->get_filho_direito() != NULL)
                return this->pesquisar(k, v->get_filho_direito());
            else
                return v;
        }
    }

    node<T> *incluir(T k)
    {
        node<T> *pai = pesquisar(k, root());
        node<T> *novo = new node<T>(pai, k);

        if (k < pai->get_chave())
            pai->set_filho_esquerdo(novo);

        else
            pai->set_filho_direito(novo);

        return novo;
    }

    int altura(){
        return this->altura_(root_);
    }

    int profundidade(node<T> *no){
        int p = this->profundidade_rec(no);
       return p;
    }

    void swapElements(node<T> * n, node<T> * w){
            T aux = n->get_chave();
            n->set_chave(w->get_chave());
            w->set_chave(aux);
        }

    void remove(T ch){
        node<T> * no = this->pesquisar(ch, this->root());
        node<T> * pai = no->get_pai();

        if (no->is_external()){
            if (no == pai->get_filho_direito() ) pai->set_filho_direito(NULL);
            if (no == pai->get_filho_esquerdo() ) pai->set_filho_esquerdo(NULL);
        }
        else{
            if (no->get_filho_direito() != NULL && no->get_filho_esquerdo() == NULL){
                this->swapElements(no, no->get_filho_direito());
                no->set_filho_direito(NULL);
                return;
            }
            if (no->get_filho_esquerdo() != NULL && no->get_filho_direito() == NULL){
            this->swapElements(no, no->get_filho_esquerdo());
            no->set_filho_esquerdo(NULL);
            return;
            }

            if (no->get_filho_esquerdo() != NULL && no->get_filho_direito() != NULL){
                node<T> * s = sucessor(no);
                this->swapElements(no, s);
                
                if(s == s->get_pai()->get_filho_esquerdo()) s->get_pai()->set_filho_esquerdo(NULL);
                if(s == s->get_pai()->get_filho_direito()) s->get_pai()->set_filho_direito(NULL);

                
                return;
                

        }
            
    }
    }
    node<T> * sucessor(node<T> * no) {
    if (no == NULL) {
      return NULL;
    }
    if (no->get_filho_direito() != NULL) {
      node<T> * novo_no = no->get_filho_direito();
      while (novo_no->get_filho_esquerdo() != NULL) {
        novo_no = novo_no->get_filho_esquerdo();
      }
      return novo_no;
    } else {
       node<T> * pai = no->get_pai();
      while (pai != NULL && no == pai->get_filho_direito()) {
        no = pai;
        pai = pai->get_pai();
      }
      return pai;
    }
  }
    vector<node<T>*> nos_emordem(){
        vector<node<T>*> nos;

        return this->nos_emordem_rec(nos, root());
    }
    vector<node<T>*> nos_pre_ordem(){
        vector<node<T>*> nos;

        return this->nos_pre_ordem_rec(nos, root());
    }
    vector<node<T>*> nos_pos_ordem(){
        vector<node<T>*> nos;

        return this->nos_pos_ordem_rec(nos, root());
     }

    void print(vector<node<T>*> nos){
        for (node<T> *i:nos)
            cout << i->get_chave() << ' ';
    }

    int index_emordem(node<T>* no){
        vector<node<T>*> v = this->nos_emordem();
        int index = -1;
        auto it = find(v.begin(), v.end(), no);
        if (it != v.end())
            index = it - v.begin();
        
        return index;
    }

    vector<vector<string> > preencheMatriz(){
        int linhas = this->altura()+1;
        vector<string> elementos;

        for (node<T> *i: this->nos_emordem())
            elementos.push_back(to_string(i->get_chave()));

        vector<vector<string>> grid(linhas, vector <string>(elementos.size(), " "));

        for (node<T>* no: this->nos_emordem()) 
            grid[this->profundidade(no)][this->index_emordem(no)] = elementos[index_emordem(no)];
            
        return grid;
    }

    void print_vector(){
        vector<vector<string>> v = this->preencheMatriz();
        for(int i = 0; i<v.size(); i++){
            for(int j = 0; j <v[i].size(); j++){
                cout << v[i][j] << " ";
            }
            cout << " " << endl;
        }
        cout << " "<<endl;
}


};


template <typename T>
void test()
{
    arvore_b<T> a1(10);
    node<T> *raiz = a1.root();

    a1.incluir(5);
    a1.incluir(8);
    a1.incluir(15);
    a1.incluir(13);
    a1.incluir(22);
    a1.incluir(4);
    a1.incluir(6);
    a1.incluir(9);
    a1.incluir(30);

    cout<<"Ordem: ";
    a1.print(a1.nos_emordem());
    cout<< endl;
    cout<<"Pre-ordem: ";
    a1.print(a1.nos_pre_ordem());
    cout<< endl;
    cout<<"Pos-ordem: ";
    a1.print(a1.nos_pos_ordem());
    cout<< endl;
    cout<<"altura: "<<a1.altura() << endl;
    
    a1.print_vector();

    a1.remove(8);
    

    a1.print_vector();
};

int main()
{
    test<int>();
    return 0;
}
