import java.util.*;
public class AestheticallyPleasingTrees {
    public static boolean isPleasing(ArrayList<Integer> trees){
        System.out.println(trees);
        boolean isTaller;
        boolean itIsPleasing=true;
        if (trees.get(0)<trees.get(1))
            isTaller=true;
        else if (Objects.equals(trees.get(0), trees.get(1)))
            return false;
        else isTaller=false;
        for (int i=1; i<trees.size()-1; i++){
            if ((trees.get(i)<=trees.get(i+1)&& isTaller) || (trees.get(i)>=trees.get(i+1)&& !isTaller) ){
                itIsPleasing=false;
            break;}
            isTaller=!isTaller;
        }
        System.out.println(itIsPleasing);
        return itIsPleasing;
    }
    public static void copy(ArrayList<Integer> arr,ArrayList<Integer>arr1){
        arr.addAll(arr1);
    }
    public static int waysCount(ArrayList<Integer> trees){
        int count=0;
        if (isPleasing(trees))
            return 0;
        else{
            ArrayList<Integer> newTrees= new ArrayList<>();
            int index=0;
            while (index<trees.size()){
                copy(newTrees,trees);
                newTrees.remove(index);
                if (isPleasing(newTrees))
                    count++;
                index+=1;
                newTrees.clear();
            }
            if (count>0) return count;
            else return -1;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> trees= new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your trees heights in numbers and enter any letter when you are done:");
        while (scanner.hasNextInt()){
        trees.add(scanner.nextInt());
        }
        System.out.println(waysCount(trees));
    }
}
