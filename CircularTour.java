public class CircularTour {
    public int findTour(int petr[],int dist[]){
        int len = petr.length;
        int break_count = 0;
        int curr_petrol = 0;
        int front = 0,rear = 0;

        for(int i=0;i<len;i++){

            int distance = dist[i];
            curr_petrol+=petr[i];

            if(curr_petrol<distance){
                break_count+=1;
                curr_petrol = 0;
                front = (i!=len-1) ? i+1 : 0;
                if(break_count==1){
                    rear = i;
                }
            }
            else{
                curr_petrol-=distance;
            }
        }

        if(front==0 && break_count>0){
            int temp = rear;
            rear = front;
            front = temp;
        }
        for(int i=0;i<front+1;i++){

            int distance = dist[i];
            curr_petrol+=petr[i];

            if(curr_petrol<distance){
                return -1;
            }
            else{
                curr_petrol-=distance;
            }
        }

        return front;
    }

    public static void main(String[] arg){
        CircularTour obj = new CircularTour();

        // int petr[] = {1,2,3,4,5};
        // int dist[] = {3,4,5,1,2};

        int petr[] = {43, 29, 73, 59, 37, 54, 4, 34, 91, 68, 69, 1, 89, 50, 4, 64, 54, 87, 53, 76, 58, 37, 15, 61, 29, 51, 57, 95, 100, 40, 29, 1, 48, 60, 36};
        int dist[] = {22, 69, 90, 9, 99, 9, 49, 34, 49, 55, 47, 30, 47, 98, 91, 34, 98, 93, 26, 97, 89, 30, 61, 22, 5, 28, 49, 3, 98, 44, 3, 4, 82, 39, 52};
        System.out.println(obj.findTour(petr,dist));
        //System.out.println(petr.length);
        //System.out.println(dist.length);
    }
}
