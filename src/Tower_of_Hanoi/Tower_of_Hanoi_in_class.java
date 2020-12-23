package Tower_of_Hanoi;
public class Tower_of_Hanoi_in_class {

        static int moves=0; //number of moves so far
        static void hanoi(int   height, char  fromPole, char  toPole, char  withPole){
            if (height >= 1){
                hanoi(height-1, fromPole, withPole, toPole);
                moveDisk(fromPole, toPole);
                hanoi(height-1, withPole, toPole, fromPole);
            }
        }
        static void moveDisk(char fromPole, char toPole){
            moves++;
            System.out.print(fromPole);
            System.out.print(toPole);
            System.out.print(((moves % 20)==0) ? '\n' : ' ');
        }

        public static void main(String[] args){
            long time1, time2; //for benchmarking
            int TowerHeight;
            char FromPole='A', ToPole='C', WithPole='B';

            TowerHeight = MyConsole.readInt("Enter Tower height");
            time1 = System.currentTimeMillis();
            hanoi(TowerHeight, FromPole, ToPole, WithPole);
            time2 = System.currentTimeMillis();
            System.out.println();
//          // print execution time in msec
            System.out.println(time2-time1+" msec execution time");
            System.out.println(moves+" moves");
        }
    }

