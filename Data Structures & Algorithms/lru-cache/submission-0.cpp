class Node{
    public:
    int key;
    int value;
    Node *next,*prev;
    Node(int a,int b){
        key = a;
        value = b;
        next=NULL;
        prev=NULL;
    }
};
class LRUCache {
public:
    int capacity = 0;
    Node *head = new Node(-1,-1);
    Node *tail = new Node(-1,-1);
    unordered_map<int,Node*> map;
    LRUCache(int c) {
        
    head->next=tail;
    tail->prev=head;
        capacity = c;
    }

    void appendNode(int key, int value){
        Node *temp = new Node(key,value);
        map[key]=temp;
        Node *p = tail->prev;
        temp->next=tail;
        p->next=temp;
        temp->prev=p;
        tail->prev=temp;
    }
    Node* deleteNode(int key){
        Node *temp=map[key];
        map.erase(key);
        Node *p = temp->prev, *n = temp->next;
        p->next=n;
        n->prev=p;
        temp->next=NULL;
        temp->prev=NULL;
        return temp;
    }
    
    int get(int key) {
        if(map.count(key)==0){
            return -1;
        }
        else{
            Node *temp = deleteNode(key);
            appendNode(temp->key,temp->value);
            return temp->value;
        }
    }
    
    void put(int key, int value) {
        if(map.count(key)==0){
            if(capacity==0){
                deleteNode(head->next->key);
                appendNode(key,value);
            }
            else{
                appendNode(key,value);
            }
            capacity--;
        }
        else{
            deleteNode(key);
            appendNode(key,value);
        }
    }
};
