package Hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanString {
    public static void main(String[] args) {
        // Empty
    }

    static void welcomeMessage(){
        String message = "Welcome to Hangman\n";
        System.out.println(message);
        int IMAGE_DISPLAY_INDEX = 4;
        HangmanDisplay.displayHangmanImage(IMAGE_DISPLAY_INDEX);
    }

    static String getPlayerName() {
        Scanner user = new Scanner(System.in);

        System.out.print("Enter Name: ");
        return user.next().trim().strip();
    }

    public static String convertListToString(ArrayList<String> listNeeded){
        String word = "";
        for (String character : listNeeded) {
            word = word.concat(String.valueOf(character));
        }
        return word;
    }

    static String getSecretWordCategory(){
        String[] categories = {"Animal", "Car", "Country", "Medicine", "Music", "Profession", "Sport", "Vegetable", "Fruit"};

        return categories[(int) (Math.random() * categories.length)];
    }

    static String getSecretWord(String category){
        String[] wordList;

        switch (category){
            case "ANIMAL" -> wordList = new String[]{"Antelope", "Arctic wolf", "Badger", "Bald eagle", "Porcupine", "Bat", "Bear", "Camel", "Chimpanzee", "Coyote", "Deer",
                    "Elephant", "Elk", "Giraffe", "Gorilla", "Hare", "Hedgehog", "Hippopotamus", "Koala", "Leopard", "Lion", "Lizard", "Mole",
                    "Monkey", "Owl", "Panda", "Rabbit", "Raccoon", "Rat", "Bison", "Reindeer", "Squirrel", "Walrus", "Wolf", "Woodpecker",
                    "Wombat", "Possum", "Chipmunk", "Porcupine", "Hedgehog", "Mongoose", "Meerkat", "Otter", "Raccoon", "Hyena", "Jackal",
                    "Fox", "Monkey", "Red panda", "Deer", "Scimitar Oryx", "Kangaroo", "Tiger", "Cheetah", "Bear", "Lion", "Zebra", "Possum",
                    "Giraffe", "Wombat", "Elephant", "Chimpanzee", "Gorilla", "Bison", "Hippopotamus", "Rhinoceros", "Black Leopard", "Jaguar",
                    "Puma", "Toucan", "King Fisher", "Swift", "Parrot", "HummingBird", "Dove", "Pigeon", "Hornbill", "Spoonbill", "Bee-Eater",
                    "Grebe", "Guinea Fowl", "Goose Bird", "Woodpecker", "Penguin", "Swallow", "Passerine", "Heron", "Gull", "Albatross",
                    "Cuckoo", "Peafowl", "Eagle", "Moa", "Elephant bird", "Vulture", "Raven", "Seahorse", "Sea lion", "Seal", "Shark", "Whale",
                    "Turtle", "Octopus", "Starfish", "Crab", "Squid", "Oyster", "Tuna"};
            case "CAR" -> wordList = new String[] {"Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Buick", "Cadillac", "Chevrolet", "Chrysler",
                    "Citroen", "Dodge", "Ferrari", "Fiat", "Ford", "Geely", "General Motors", "GMC", "Honda", "Infiniti", "Jaguar", "Jeep",
                    "Kia", "Koenigsegg", "Lamborghini", "Land Rover", "Lexus", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini",
                    "Mitsubishi", "Nissan", "Pagani", "Peugeot", "Porsche", "Ram", "Renault", "Rolls Royce", "Saab", "Subaru", "Suzuki",
                    "Tata Motors", "Tesla", "Toyota", "Volkswagen", "Volvo"};
            case "COUNTRY" -> wordList = new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia",
                    "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
                    "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
                    "Cape Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia",
                    "Comoros", "Democratic Republic of the Congo", "Republic of the Congo", "Costa Rica", "Cote d’Ivoire", "Croatia", "Cuba",
                    "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt",
                    "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Swaziland", "Ethiopia", "Fiji", "Finland", "France", "Gabon",
                    "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                    "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan",
                    "Jordan","Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos",
                    "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia",
                    "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Federated States of Micronesia",
                    "Moldova", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands",
                    "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Panama",
                    "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda",
                    "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe",
                    "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
                    "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "South Sudan", "Suriname", "Sweden", "Switzerland", "Syria",
                    "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
                    "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan",
                    "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
            case "MEDICINE" -> wordList = new String[]{"aetiologist", "anaesthetist", "anatomist", "andrologist", "audiologist", "bacteriologist",
                    "balneologist", "cardiologist", "chiropodist", "consultant", "dental hygienist", "dentist", "dermatologist", "diagnostician",
                    "dietitian", "district nurse", "doctor", "electrophysiologist", "embryologist", "endocrinologist", "endodontist", "epidemiologist",
                    "exodontist", "forensic scientist", "gastroenterologist", "geriatrician", "gerontologist", "gynaecologist", "haematologist",
                    "hydrotherapist", "immunologist", "intern", "laboratory technician", "laryngologist", "matron", "midwife", "myologist", "neonatologist",
                    "nephrologist", "neuroanatomist", "neurologist", "neuropathologist", "neurophysiologist", "neuropsychiatrist", "neurosurgeon", "nosologist",
                    "nurse", "nursing officer", "nutritionist", "obstetrician", "odontologist", "oncologist", "ophthalmologist", "optician", "optometrist",
                    "orthodontist", "orthopaedist", "osteologist", "otolaryngologist", "otologist", "paediatrician", "paediatrics", "paramedic", "pathologist",
                    "pharyngologist", "physiotherapist", "plastic surgeon", "proctologist", "psychiatrist", "psychoanalyst", "psychologist", "radiographer",
                    "radiologist", "resident", "rheumatologist", "rhinologist", "serologist", "speech therapist", "surgeon", "syphilologist", "therapist",
                    "toxicologist", "trichologist", "urologist", "venereologist", "veterinary surgeon", "virologist"};
            case "PROFESSION" -> wordList = new String[] {"accountant", "actor", "actress", "air traffic controller", "architect", "artist", "attorney",
                    "banker", "bartender", "barber", "bookkeeper", "builder", "butcher", "carpenter", "cashier", "chef", "coach", "designer", "developer",
                    "economist", "editor", "electrician", "engineer", "farmer", "filmmaker", "fisherman", "flight attendant", "jeweler", "judge",
                    "lawyer", "mechanic", "musician", "painter", "pharmacist", "photographer", "physician", "physician's assistant", "pilot", "plumber",
                    "police officer", "politician", "professor", "programmer", "psychologist", "receptionist", "salesperson", "secretary", "singer",
                    "surgeon", "teacher", "translator", "undertaker", "veterinarian", "videographer", "waiter", "waitress", "writer"};
            case "Music" -> wordList = new String[] {"Rock", "Rhythm and blues", "Classical", "Opera", "Country", "Jingles", "Lullaby", "Rap", "Dance",
                    "Electronic", "Pop", "Hip pop", "Instrumental", "Gospel", "Jazz", "Karaoke", "Soul", "Disco", "Reggae", "Songwriter", "Soundtrack",
                    "Acappella", "Vocal", "Juju", "Afro", "Fuji", "Calypso"};
            case "SPORT" -> wordList = new String[] {"kayaking", "bobsleigh", "canoeing", "cross-country skiing", "rafting", "skibobbing", "surfing",
                    "snorkeling", "swimming", "bodyboarding", "diving", "freediving", "paddleboarding", "rowing", "scuba diving", "synchronized swimming",
                    "aerobics", "aikido", "archery", "artistic gymnastics", "baton twirling", "bodybuilding", "boxing", "cross-country equestrianism",
                    "cross-country running", "cycling", "discus throw", "equestrianism", "fencing", "figure skating", "horse racing", "judo", "karate", "kendo",
                    "kickboxing", "kung fu", "long jump", "marathon", "mixed martial arts", "pole vault", "powerlifting", "racewalking", "rhythmic gymnastics",
                    "sprint", "sumo", "sword-fighting", "trail running", "trampolining", "tumbling", "walking", "weightlifting", "wrestling", "baseball",
                    "basketball", "tennis", "badminton", "bowling", "cricket", "curling", "dodgeball", "football", "golf", "handball", "hockey", "horseball", "hurling",
                    "ice hockey", "kickball", "lacrosse", "paddle", "polo", "racquetball", "rinkball", "rounders", "rugby", "soccer", "softball",
                    "squash", "table tennis", "volleyball", "water polo", "abseiling", "bouldering", "gliding", "kiteboarding", "kitesurfing", "parachuting",
                    "paragliding", "parasailing", "skateboarding", "skydiving", "skysurfing", "snowboarding", "wakeboarding", "windsurfing", "climbing",
                    "cross-country cycling", "hiking", "mountaineering", "drifting", "formula racing", "kart racing", "rallycross", "checkers",
                    "chess", "mahjong"};
            case "VEGETABLE" -> wordList = new String[] {"eggplant", "asparagus", "lentils", "bean sprouts", "black-eyed peas", "green beans",
                    "kidney beans", "butter bean", "mung beans", "navy beans", "peanuts", "pinto beans", "runner beans", "split peas",
                    "soy beans", "peas", "cabbage", "cauliflower", "celery", "endive", "basil", "caraway", "coriander", "fennel", "lavender",
                    "lemongrass", "oregano", "parsley", "rosemary", "sage", "thyme", "lettuce", "arugula", "mushrooms", "nettles", "okra",
                    "onions", "chives", "garlic", "leek", "onion", "pepper", "rhubarb", "beetroot", "carrot", "water chestnut", "ginger",
                    "parsnip", "radish", "potato", "sweet potato", "yam", "turnip", "broccoli", "spinach", "Brussels sprouts", "Oyster Plant",
                    "sweetcorn", "squashes", "courgette", "Zucchini", "cucumber", "tomato", "watercress"};
            case "FRUIT" -> wordList = new String[] {"Apple", "Apricot", "Avocado", "Banana", "Bilberry", "Blackberry", "Blackcurrant",
                    "Black sapote", "Blueberry", "Boysenberry", "Breadfruit", "Cactus pear", "Crab apple", "Currant", "Cherry", "Custard Apple",
                    "Chico fruit", "Cloudberry", "Coconut", "Cranberry", "Date", "Dragonfruit", "Elderberry", "Fig", "Goji berry", "Gooseberry", "Grape",
                    "Raisin", "Grapefruit", "Guava", "Hala Fruit", "Honeyberry", "Huckleberry", "Jackfruit", "Japanese plum", "Jostaberry",
                    "Juniper berry", "Kiwifruit", "Kumquat", "Lemon", "Lime", "Loganberry", "Loquat", "Longan", "Lychee", "Mango", "Mangosteen",
                    "Marionberry", "Melon", "Cantaloupe", "Galia melon", "Honeydew", "Watermelon", "Miracle fruit", "Monstera Delisiousa",
                    "Mulberry", "Nance", "Nectarine", "Orange", "Tangerine", "Papaya", "Passionfruit", "Peach", "Pear", "Persimmon",
                    "Plantain", "Plum", "Pineapple", "Pineberry", "Plumcot", "Pomegranate", "Pomelo", "Purple mangosteen", "Quince", "Raspberry",
                    "Salmonberry", "Rambutan", "Redcurrant", "Salal berry", "Salak", "Satsuma", "Soursop", "Star apple", "Star fruit",
                    "Strawberry", "Surinam cherry", "Tamarillo", "Tamarind", "Tangelo", "Tayberry", "Ugli fruit", "White currant"};
            default -> throw new IllegalStateException("Unexpected value: " + category);
        }

        return wordList[(int) (Math.random() * wordList.length)];
    }

    static String getUserGuess(){
        Scanner user = new Scanner(System.in);

        System.out.print("Guess: ");
        return user.next().trim().strip();
    }

}
