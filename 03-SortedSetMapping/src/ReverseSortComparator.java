import java.util.Comparator;
import com.ibm.hibernate.Certificate;

public class ReverseSortComparator implements Comparator<Certificate>{
	public int compare(Certificate o1, Certificate o2) {
		final int BEFORE = -1;
		final int AFTER = 1;

		/* To reverse the sorting order, multiple by -1 */
		if (o2 == null) return BEFORE * -1;

		Comparable thisCertificate = o1.getName();
		Comparable thatCertificate = o2.getName();

		if(thisCertificate == null) return AFTER * 1; 
		else if(thatCertificate == null) return BEFORE * -1;
		else return thisCertificate.compareTo(thatCertificate) * -1;
	}
}