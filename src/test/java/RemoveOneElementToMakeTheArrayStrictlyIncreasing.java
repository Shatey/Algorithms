import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

    @Test
    void test() {
        assertTrue(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        assertFalse(canBeIncreasing(new int[]{2, 3, 1, 2}));
        assertFalse(canBeIncreasing(new int[]{1, 1, 1}));
        assertTrue(canBeIncreasing(new int[]{1, 1}));
        assertTrue(canBeIncreasing(new int[]{105,924,32,968}));
        assertFalse(canBeIncreasing(new int[]{541,783,433,744}));
    }

    public boolean canBeIncreasing(int[] nums) {
        boolean canRemoveItem = true;
        int last=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=last){
                // we did not remove any item before
                if(canRemoveItem){
                    canRemoveItem=false;

                    // if i is the last item just remove it
                    if(i==nums.length-1) return true;
                    // can remove item at index i
                    if(nums[i+1]>nums[i-1]){
                        last=nums[i-1];
                        // can remove item at index i-1
                    }else if(nums[i+1]>nums[i] && (i-2<0 || nums[i]>nums[i-2])){
                        last=nums[i];
                    }else {
                        return false;
                    }

                }else{
                    return false;
                }
            }else{
                last=nums[i];
            }
        }

        return true;
    }
}
