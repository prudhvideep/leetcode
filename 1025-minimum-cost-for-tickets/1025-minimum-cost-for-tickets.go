func mincostTickets(days []int, costs []int) int {
    isDayPresent := make(map[int]bool)
    daysCost := make([]int,396)

    for _,day := range days {
      isDayPresent[day] = true
    }

    return solve(1,days,isDayPresent,costs,daysCost)
}

func min(a,b int) int{
  if a <= b {
    return a
  } 
  return b
}

func solve(day int, days []int, isDayPresent map[int]bool,costs []int,daysCost []int) int{
  if day > days[len(days)-1] {
    return 0
  }

  if !isDayPresent[day] {
   return solve(day+1,days,isDayPresent,costs,daysCost)
  }
  
  cost := 0
  if daysCost[day+1] == 0 {
    daysCost[day+1] = solve(day+1,days,isDayPresent,costs,daysCost)
  }

  if daysCost[day+7] == 0 {
    daysCost[day+7] = solve(day+7,days,isDayPresent,costs,daysCost)
  }

  if daysCost[day+30] == 0 {
    daysCost[day+30] = solve(day+30,days,isDayPresent,costs,daysCost)
  }
  
  cost = min(costs[0]+daysCost[day+1],min(costs[1]+daysCost[day+7],costs[2]+daysCost[day+30]))

  return cost;
}