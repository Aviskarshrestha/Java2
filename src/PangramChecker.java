    public class PangramChecker {
        String alphabets="abcedfghijklmnopqrstuvwxyz";
        public boolean check(String sentence){
            sentence=sentence.toLowerCase();
            for(int i=0; i<26; i++) {
                if (sentence.contains(alphabets.substring(i, i + 1))) {

                } else {
                    return false;
                }
            }
            return true;


        }
        public static void main(String args[]){
           String sent="This ias a sentence";
           sent.chars().filter(x->x>='a' && x<='z').distinct().forEach(x->{System.out.println((char)x);});

        }
    }