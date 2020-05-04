// https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
long min=0;
    private void firstBadVersion(long start, long end){
        if(start>end)
            return;
        long mid=(start+end)/2;
        if(isBadVersion((int)mid)){
            if(mid<min) min=mid;
            firstBadVersion(start, mid-1);
        }
        else firstBadVersion(mid+1, end);
    }
    public int firstBadVersion(int n) {
        min=n;
        firstBadVersion(1,n);
        return (int)min;
    }
}