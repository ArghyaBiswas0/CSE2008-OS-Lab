//shortest job first scheduling algorithm

#include<stdio.h>
#include <stdbool.h> 
void main() {
	int AT[5]={1,2,3,4,5};
	int BT[5]={7,5,1,2,8};
	bool completed[5]={false,false,false,false,false};
	int CT[5];
	int TAT[5];
	int WT[5];
	int tym=1;
	bool all_cmplt=true;
	while(true) {
		int indx=-1;
		for(int i=0;i<5;i++) {
			if(indx==-1 && !completed[i] && AT[i]<=tym) {
				indx=i;
			}
			if(!completed[i] && AT[i]<=tym && BT[i]<BT[indx]) {
				indx=i;
			}
		}
		tym+=BT[indx];
		CT[indx]=tym;
		completed[indx]=true;

		all_cmplt=true;
		for(int i=0;i<5;i++) {
			if(completed[i]==false) {
				all_cmplt=false;
				break;
			}
		}
		if(all_cmplt) {
			break;
		}
	}
	for(int i=0;i<5;i++) {
		TAT[i]=CT[i]-AT[i];
		WT[i]=TAT[i]-BT[i];
	}
	printf("AT\tBT\tCT\tTAT\tWT\t\n");
	for(int i=0;i<5;i++) {
		printf("%d\t%d\t%d\t%d\t%d\t\n",AT[i],BT[i],CT[i],TAT[i],WT[i]);
	}
}
