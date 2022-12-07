class Programa {
    public static void main(String[] args) {
        double f = 4.35;

        int r = (int) (100 * f);

        int s = r / 10;

        int t = s / 10;

        int u = t / 10;

        System.out.println("r = " + r + ", s = " + s + ", t = " + t + ", u = " + u);
    }

    static int B(int p, int q, int V[]) {

        int k, r1, r2;

        if (q - p > 1) {

            k = (p + q) / 2;

            r1 = B(p, k, V);

            r2 = B(k + 1, q, V);

            if (V[r1] >= V[r2])

                return (r1);

            else

                return (r2);

        }

        else

        if (V[p] >= V[q])

            return (p);

        else

            return (q);

    }
}