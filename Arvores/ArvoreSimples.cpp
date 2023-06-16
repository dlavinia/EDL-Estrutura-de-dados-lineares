#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class node{
    private:
        int  o;
        node * pai;
        vector<node*> children_;

    public:
        node(node * pai, int o){
            this-> o = o;
            this-> pai = pai;
        }
        
        void add_child(node* n){
            this->children_.push_back(n);
        }

        //void remove_child(node* o){
         //   this->children_.erase(o);}

        int childrenNumber(){
            return this->children_.size();
        }
        
        int get_element(){
            return this->o;
        }

        void set_element(int o){
            this->o = o;
        }

        node* get_parent(){
            return this->pai;
        }

        const vector<node*> &children(){
            return children_;
        }
};

class arvore_simples{
    private:
        node * root_;
        unsigned int size_;

        int height_(node* n){
            int h = 0;
            vector<node*>::const_iterator it = n->children().begin();
            // auto = n->children().begin();
            while (it!=n->children().end()){
                h = max(h,height_(*it));
                it++;
            }
            return h+1;
        }
       
        void print(node * n){
            cout << n->get_element();
            if (n->children().size()>0){
                cout << " ( ";
                vector<node*>::const_iterator it = n->children().begin();
                // auto = n->children().begin();
                while (it!=n->children().end()){
                print(*it);
                it++;
            }
            cout << ") ";

            } else{
                cout << " ";
            }
        }

        int depth_(node* n){
            if (n== this->root_){
                return 0;
            }
            else{
                return (1+ this->depth_(n->get_parent()));
            }
        }

    public:
        arvore_simples(int o){
            root_ = new node(NULL, o);
            size_ = 1;
        }

        node* add_child(node * pai, int o){
            node* new_node= new node(pai, o);
            pai->add_child(new_node);
            size_++;
            return new_node;
        }

        int height(){
        return this->height_(root_);
        }
        node * root(){
            return this->root_;
        } 
        int depth(node* n){
            return this->depth_(n);
        }
        node* parent(node* n){
            return n->get_parent();
        }  

        void swapElements(node* n, node* w){
            int aux = n->get_element();
            n->set_element(w->get_element());
            w->set_element(aux);
        }

        void print(){
            print(root_);
        }
        bool isInternal(node* n){
            return (n->childrenNumber() > 0);
        }
        bool isExternal(node * n){
            return (n->childrenNumber() == 0);
        }
        bool isRoot(node* n){
            return (n == this-> root_);
        }
         int replace(node * n, int o){
            n->set_element(o);
        }

        const vector<node*> &children(node * n){
            return n->children();
        }
};

int main() {
   
   arvore_simples a1(10);

   node*raiz = a1.root();
   a1.add_child(raiz, 20);
   node*b1 = a1.add_child(raiz, 30);

   a1.add_child(b1, 40);

   cout << "Quantidade de filhos da raiz: " << a1.root()->childrenNumber() << endl;
   cout << "Altura da árvore: " << a1.height() << endl;
   cout << "Profudidade do 30: " << a1.depth(b1) << endl;
   cout << "Pai do 40: " << a1.parent(b1)->get_element() << endl;

   a1.print();
   cout << endl;

    return 0;
}

