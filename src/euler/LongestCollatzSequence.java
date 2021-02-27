package euler;

import org.apache.log4j.Logger;

/**
 * Problem 14. The following iterative sequence is defined for the set of
 * positive integers: n → n/2 (n is even) n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * @author jsavely
 */
public class LongestCollatzSequence {

    static Logger log = Logger.getLogger(LongestCollatzSequence.class.getName());

    int getCollatzSequence(long n) {
        int len = 0;
        while (n > 1) {
            len++;
            n = (n % 2 == 0) ? (n = n / 2) : (n = 3 * n + 1);
        }
        return ++len;
    }

    void findMaxSequence() {
        int startNum = 0;
        int maxChain = 0;
        for (int i = 1; i < 1_000_001; i++) {
            int chain = getCollatzSequence(i);
            if (chain > maxChain) {
                maxChain = chain;
                startNum = i;
               log.info("maxChain = " + maxChain + " startNum = " + startNum);
            }
            // DEBUG log.info("chain = "+ chain + " start = " + i);
        }
        log.info("maxChain = " + maxChain + " startNum = " + startNum);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LongestCollatzSequence l = new LongestCollatzSequence();
        l.findMaxSequence();
        // DEBUG log.info("getCollatzSequence " + l.getCollatzSequence(626331));
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }
}
