package phonelog상속;

public class FreeCall extends Call {
	
	@Override
	void computeCharge() {
		charge = 0;
		sumDuration += duration;
		sumCharge += charge;
	}

	@Override
	void printChargeType() {
		System.out.printf("\t무료");
	}
}
