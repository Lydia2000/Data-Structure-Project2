import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
		System.out.println("Done");
    }
	
	//quick sort
	public void sort(){
		quickSort(0, lst.size()-1);
		System.out.println("Done");
	}
	
	
	private void quickSort(int leftbound, int rightbound){
		if(leftbound >= rightbound) 
		return;
		int pivotindex = (leftbound + rightbound) / 2;
		int pivot = lst.get(pivotindex).count;
        swap(pivotindex,rightbound);
        int swapIndex = leftbound;
        for (int i = leftbound; i < rightbound; ++i)
        {
            if (lst.get(i).count <= pivot)
            {
                swap(i, swapIndex);
                ++swapIndex;
            }
        }
        swap(swapIndex, rightbound);
 
        quickSort(leftbound, swapIndex - 1);
        quickSort(swapIndex + 1, rightbound);
    }
	
	
	private void swap(int aIndex, int bIndex){
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lst.size();i++){
			Keyword k = lst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}
}

