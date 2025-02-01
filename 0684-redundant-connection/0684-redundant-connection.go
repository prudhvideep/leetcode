func find(node int) int {
	if parent[node] == node {
		return node
	}

	return find(parent[node])
}

var parent []int

func findRedundantConnection(edges [][]int) []int {
	parent = make([]int, len(edges)+1)
	for i := range parent {
		parent[i] = i
	}

	redEdge := make([]int, 2)

	for _, edge := range edges {
		u, v := edge[0], edge[1]

		pu, pv := find(parent[u]), find(parent[v])

		if pu == pv {
			redEdge[0] = u
			redEdge[1] = v
		} else {
			if pu < pv {
        parent[pv] = pu
      }else {
        parent[pu] = pv
      }
 		}
	}

	return redEdge

}