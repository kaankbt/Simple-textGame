package tutorials;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Objects
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();

        //Game veriables
        String[] enemies = {"İskelet", "Zombi", "Terörist", "Mülteci"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player veriables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionAmounth = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("Zindana Hoşgeldin!");

        GAME:
        while (running) {
            System.out.println("-----------------------------------------");

            int enemyHealth = rand.nextInt(health);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " görüldü! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tSağlığın: " + health);
                System.out.println("\t" + enemy + "'nın Sağlığı: " + enemyHealth);
                System.out.println("\n\tŞimdi ne yapacaksın?");
                System.out.println("\t1. Saldır");
                System.out.println("\t2. Sağlık iksiri iç");
                System.out.println("\t3. Koş!");
                System.out.println();

                String input = kb.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> Düşmana verdiğin hasar " + damageDealt);
                    System.out.println("\t> Aldığın hasar " + damageTaken);

                    if (health < 1) {
                        System.out.println("\t> Çok fazla hasar aldın devam etmek için çok zayıfsın!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionAmounth;
                        numHealthPotions--;
                        System.out.println("\t>İksir içildi... kazanılan sağlık " + healthPotionAmounth
                                + "\n\t> Şuanki can değerin :" + health + "can."
                                + "\n\t> Kalan iksir sayın " + numHealthPotions);
                    } else {
                        System.out.println("\t> Sağlık iksirin kalmadı yeni bir tane istiyorsan Düşmanını yenmekten başka çaren yok!");

                    }
                } else if (input.equals("3")) {
                    System.out.println(enemy + "\t'den kaçarak uzaklaştın... ");
                    System.out.println("Tıpkı bir korkak gibi...");
                    continue GAME;
                } else {
                    System.out.println("\t Geçersiz tuşlama!!!");
                }
            }
            if (health < 1) {
                System.out.println("Savaşta ağır yaralandın!");
                break;
            }
            System.out.println("-----------------------------------------");
            System.out.println(" # " + enemy + "öldürüldü! #");
            System.out.println(" # " + "Şuanda " + health + " canın var.");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("# Kesilen düşmandan Sağlık ikisi düşürdün.. #");
                System.out.println(" # " + "Şuanda " + numHealthPotions + " iksirin var. #");
            }
            System.out.println("-----------------------------------------");
            System.out.println("Şimdi ne yapacaksın?");
            System.out.println("1. Savaşmaya devam et.");
            System.out.println("2. Savaştan çık");

            String input = kb.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Geçersiz tuşlama!");
                input = kb.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("Savaş kaldığı yerden devam ediyor...");
            } else if (input.equals("2")) {
                System.out.println("Savaştan çıkışın başarıyla gerçekleştirildi.");
            }

        }
        System.out.println("###########################");
        System.out.println("OYNADIĞIN İÇİN TEŞEKKÜRLER");
        System.out.println("###########################");

    }
}

