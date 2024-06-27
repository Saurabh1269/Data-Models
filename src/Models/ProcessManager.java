package Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessManager {
private ArrayList<Process> processes;
private LinkedList<Process>pendingProcessesHistory;
private LinkedList<Process>completedProcessesHistory;
  

    public ProcessManager() {
    	this.processes = new ArrayList<>();
    	this.pendingProcessesHistory = new LinkedList<>();
    	this.completedProcessesHistory = new LinkedList<>();
    	
    }
    public void addProcess(Process process) {
    }
    	public boolean removeProcess(int processId) {
    		for(Process process: processes) {
    			if( process.getProcessId()== processId) {
    				processes.remove(process);
    				return true;
    				
    			}
    		}
    		return false;
    	}
    	public Process searchProcess(int processId) {
    		for(Process process: processes) {
    			if(process.getProcessId()==processId) {
    				return process;
    				
    			}
    		}
    			return null;
    				
    }
    	public List<Process> listAllProcesses() {
            return new ArrayList<>(processes);
        }

     
     public boolean updateProcessStatus(int processId, String newStatus) {
          for (Process process : processes) {
          if (process.getProcessId() == processId) {
              process.setStatus(newStatus);
          if (newStatus.equals("Pending")) {
             addPendingProcess(process);
              } else if (newStatus.equals("Completed")) {
               addCompletedProcess(process);
                    }
            return true;
                }
            }
            return false;
        }

        
        public void addPendingProcess(Process process) {
            pendingProcessesHistory.add(process);
        }

        public void addCompletedProcess(Process process) {
            completedProcessesHistory.add(process);
        }

        public List<Process> getPendingProcessesHistory() {
            return new LinkedList<>(pendingProcessesHistory);
        }

        public List<Process> getCompletedProcessesHistory() {
            return new LinkedList<>(completedProcessesHistory);
        }
    

    
    
        public static void main(String[] args) {
            ProcessManager manager = new ProcessManager();

       
            Process process1 = new Process(1, "Project1", "Pending");
            Process process2 = new Process(2, "Bug", "Running");
            Process process3 = new Process(3,"Bug resolve","completed");
            
            manager.addProcess(process1);
            manager.addProcess(process2);
            manager.addProcess(process3);
            
            System.out.println( "Processes");
	        for (Process process : manager.listAllProcesses()) {
	            System.out.println(process);
	        }

	        System.out.println("Remove Process ID 3:");
	        manager.removeProcess(3);
	        for (Process process : manager.listAllProcesses()) {
	            System.out.println(process);
	        }

	        System.out.println("Searching Process ID 2:");
	        System.out.println(manager.searchProcess(2));

	        System.out.println("Update Process Status for ID 1 to 'Pending':");
	        boolean statusUpdated = manager.updateProcessStatus(1, "Pending");
	        System.out.println("Status Updated: " + statusUpdated);
	        for (Process process : manager.listAllProcesses()) {
	            System.out.println(process);
	        }

	        
	        System.out.println("Pending Processes History:");
	        for (Process process : manager.getPendingProcessesHistory()) {
	            System.out.println(process);
	        }

	       
	        System.out.println("Completed Processes History:");
	        for (Process process : manager.getCompletedProcessesHistory()) {
	            System.out.println(process);
       

            
        
        }
}
}