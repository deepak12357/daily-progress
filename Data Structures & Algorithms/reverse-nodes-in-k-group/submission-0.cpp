/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* curr=head,*prev = NULL, *frwd=NULL;
        while(curr!=NULL){
            frwd=curr->next;
            curr->next=prev;
            prev=curr;
            curr=frwd;
        }
        return prev;

    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k==1) return head;
        ListNode *temp=head,*res=NULL,*res1=NULL,*prev=NULL;
        int cnt=0;
        while(temp!=NULL){
            cnt++;  
            prev=temp;
            temp=temp->next;
            if(cnt==k){
                cnt=0;
                prev->next=NULL;
                if(res==NULL){
                    res=reverse(head);
                    res1=res;
                }
                else{
                    res->next=reverse(head);
                }
                while(res->next!=NULL){
                    res=res->next;
                }
                head=temp;
            }
        }
        if(head!=NULL)
            res->next=head;
        return res1;
    }
};
