func numOfSubarrays(arr []int) int {
    MOD := 1000000007
    
    for i := range arr {
      arr[i] = arr[i]%2
    }
    
    n := len(arr)
    dp_even := make([]int,n)
    dp_odd := make([]int,n)
    
    if arr[n-1] == 0 {
      dp_even[n-1] = 1
    }else{
      dp_odd[n-1] = 1
    }

    for i := n-2; i >= 0; i-- {
      if arr[i] == 0 {
        dp_odd[i] = dp_odd[i+1] 
        dp_even[i] = (1+dp_even[i+1])%MOD
      }else {
        dp_odd[i] = (1 + dp_even[i+1])%MOD
        dp_even[i] = dp_odd[i+1]
      }
    }

    count := 0

    for _,oc := range dp_odd {
      count += oc
      count %= MOD
    }

    return count

}