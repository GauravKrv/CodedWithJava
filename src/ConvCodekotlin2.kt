import java.util.*


fun main(){
    var n: Int
    var b = 1
    var w = 1
    var i : Int
    var count = 1
    var m: Int
    var x:Int
    var test: Int
    var t: Double
    var i1 = 0.0
    var j1 = 0.0
    var vel: Double
    val s = Scanner(System.`in`)
    test = s.nextInt()
    //	printf("enter n value: ");
    for (x in 0 until test) {
        n = s.nextInt()
        val a = IntArray(n)

        for (m in 0 until n) {
            a[m] = s.nextInt()
        }
        for ( i in 0 until n){

            for (j in 0 until n) {
                vel =(a[j] - a[i]).toDouble()
                if (i == j) {
                    j1++
                    continue
                }
                if (a[j] == a[i]) {
                    j1++
                    continue
                } else {
                    t = (i1 - j1) / vel
                    //	printf("case:,t=%lf, i1=%lf j1=%lf, i=%d j=%d , a[j]=%d , a[i]=%d,  vel = %lf \n",t,i1,j1,i,j,a[j],a[i],vel);
                    if (t >= 0) {
                        count++
                    } else {
                        j1++
                        continue
                    }
                    j1++
                }
            } //---> for j loop

            j1 = 0.0

            if (i == 0) {
                b = count
                w = count
            } else {
                if (count < b) { //check heree b cases
                    b = count
                }
                if (count > w) { //check heree w cases
                    w = count
                }
            }
            count = 1
            i1++
        }//-->
        println("$b $w")
        i1 = 0.0
        j1 = 0.0
        m = 0
        b = 1
        w = 1
        count = 1
    }
    }

