package phonelog상속;

import java.util.ArrayList;

public class SaleCall extends Call {
	int saleDuration, sale;
	ArrayList<Call> overlapList = new ArrayList<>();

	@Override
	void computeCharge() {
		Manager mng = Manager.getInstance();
		charge = duration * 2;
		overlapList = mng.findOverlapLog(phoneNum);
		saleDuration = duration;
		for (int i = 0 ; i < overlapList.size(); i++) {
			if (overlapList.get(i) != null) {
				overlapList.get(i).accumulateDone = false;
				saleDuration += overlapList.get(i).duration;
			}
			if(i == overlapList.size() - 1)
				accumulateDone = true;
		}
		sale = saleDuration;
		sumDuration += duration;
		sumCharge += charge;
	}

	@Override
	void printChargeType() {
		System.out.printf("\tF&F할인 (누적시간 총 %d초)", saleDuration);
	}
	
	void printTotalSale() {
		System.out.printf("%s (총 %d초) %d원 할인\n", phoneNum, saleDuration, sale);
	}
}
