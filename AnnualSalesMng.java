package javasecondlecture;
import java.util.ArrayList;
public class AnnualSalesMng {
	ArrayList<AnnualSales> alist = new ArrayList<>();
	public static void main(String[] args) {
		AnnualSalesMng pro = new AnnualSalesMng();
		pro.doit();
	}

	void doit() {
		int i = 1;
		while (i <= 10) {
			AnnualSales r = new AnnualSales();
			r.doit();
			alist.add(r);
			i++;
		}
		compute();
	}

	void compute() {
		int sum = 0;
		AnnualSales max = new AnnualSales();
		max = alist.get(0);
		for(AnnualSales i : alist) {
			sum += i.cnt;
			if(max.max < i.max)
				max = i;
		}	
		System.out.println("증가한 월 수 : " + sum + "회");
		System.out.printf("최대 증가율 : %.1f%%" + "\t%d년 %d월\n",max.max ,max.annual, max.monthMax);
	}
}
