class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        char dir = 'N';
        int curX = 0, curY = 0, maxD = 0;

        Set<Pair> set = new HashSet<>();

        for (int[] point : obstacles) {
            set.add(new Pair(point[0], point[1]));
        }

        for (int command : commands) {
            if (command != -1 && command != -2) {
                if (dir == 'N') {
                    while (command-- > 0) {
                        if (set.contains(new Pair(curX, curY + 1))) {
                            break;
                        }
                        curY++;
                    }

                } else if (dir == 'E') {
                    while (command-- > 0) {

                        if (set.contains(new Pair(curX + 1, curY))) {
                            break;
                        }
                        curX++;
                    }
                } else if (dir == 'S') {
                    while (command-- > 0) {
                        if (set.contains(new Pair(curX, curY - 1))) {
                            break;
                        }
                        curY--;
                    }
                } else if (dir == 'W') {
                    while (command-- > 0) {
                        if (set.contains(new Pair(curX - 1, curY))) {
                            break;
                        }
                        curX--;
                    }
                }
                maxD = Math.max(maxD, (int) (Math.pow(curX, 2) + Math.pow(curY, 2)));
            } else if (command == -1) {
                if (dir == 'N') {
                    dir = 'E';
                } else if (dir == 'E') {
                    dir = 'S';
                } else if (dir == 'S') {
                    dir = 'W';
                } else if (dir == 'W') {
                    dir = 'N';
                }
            } else if (command == -2) {
                if (dir == 'N') {
                    dir = 'W';
                } else if (dir == 'E') {
                    dir = 'N';
                } else if (dir == 'S') {
                    dir = 'E';
                } else if (dir == 'W') {
                    dir = 'S';
                }
            }
        }

        

        return maxD;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair newPair = (Pair) o;

            return ((this.x == newPair.x) && (this.y == newPair.y));

        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}