public class VM {

    //Create computer simulated hardware - RAM
    private int[] memory = new int[256];

    //We need registers for processing - CPU
    private int registerA = 0;
    private int registerB = 0;

    //This is our point-checker, which is what we use to know 
    //the line of code we're on
    private int pc = 0;

    //Power Switch
    private boolean isRunning = true;

    //Now we have instruction dictionary

    private final int HALT = 0; //Stops processing
    private final int LOAD_A = 1; //Load number to register A
    private final int LOAD_B = 2; //Load number to register B
    private final int ADD = 3; // Add register B to register A

        public void run() {
        System.out.println("--- VM Starting ---");

        // The main CPU loop
        while (isRunning && pc < memory.length) {
            
            // 1. FETCH
            int opcode = memory[pc]; 
            pc++; // Move to the next slot for the next turn

            // 2. DECODE & 3. EXECUTE
            switch (opcode) {
                
                case HALT:
                    isRunning = false;
                    System.out.println("Instruction: HALT (Shutting down...)");
                    break;

                case LOAD_A:
                    // Grab the next number in memory and put it into Register A
                    registerA = memory[pc];
                    pc++; // Move past the data number
                    System.out.println("Instruction: LOAD_A " + registerA);
                    break;

                case LOAD_B:
                    // Grab the next number in memory and put it into Register B
                    registerB = memory[pc];
                    pc++; // Move past the data number
                    System.out.println("Instruction: LOAD_B " + registerB);
                    break;

                case ADD:
                    // Add B into A
                    registerA = registerA + registerB;
                    System.out.println("Instruction: ADD (RegA is now " + registerA + ")");
                    break;

                default:
                    System.out.println("Unknown instruction: " + opcode + ". Crashing.");
                    isRunning = false;
                    break;
            }
        }

        System.out.println("--- VM Halted ---");
        System.out.println("Final state of Register A: " + registerA);
    }
        public static void main(String[] args) {
        VM vm = new VM();

        // Let's write a program into the VM's memory.
        // We want to load 10 into A, load 20 into B, ADD them, and HALT.
        
        vm.memory[0] = vm.LOAD_A; // At slot 0: The instruction to load A
        vm.memory[1] = 10;        // At slot 1: The data (the number 10)
        
        vm.memory[2] = vm.LOAD_B; // At slot 2: The instruction to load B
        vm.memory[3] = 50;        // At slot 3: The data (the number 20)
        
        vm.memory[4] = vm.ADD;    // At slot 4: The instruction to add them
        
        vm.memory[5] = vm.HALT;   // At slot 5: The instruction to stop

        // Start the fake computer!
        vm.run();
    }

}