func waysToSplitArray(nums []int) int {
   prefix,suffix,splits := 0,0,0

   for i:=0;i < len(nums);i++ {
    suffix += nums[i]
   }

   for i:=0;i < len(nums)-1;i++ {
    suffix -= nums[i]
    prefix += nums[i]

    if prefix >= suffix {
      splits++
    }
   }

   return splits
}