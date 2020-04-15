if __name__ == '__main__':

    burst_time = []
    print("Enter the number of process: ")
    num_processes = int(input())
    processes = []

    for i in range(0, num_processes):
        processes.insert(i, i + 1)

    print("Enter the burst time of the processes: \n")
    burst_time = list(map(int, input().split()))


    '''
    Applying bubble sort to sort process according to their burst time
    '''
    for i in range(0, len(burst_time) - 1):
        for j in range(0, len(burst_time) - i - 1):
            if burst_time[j] > burst_time[j + 1]:
                temporary = burst_time[j]
                burst_time[j] = burst_time[j + 1]
                burst_time[j + 1] = temporary
                temporary = processes[j]
                processes[j] = processes[j + 1]
                processes[j + 1] = temporary


    wait_time = []
    average_wait_time = 0
    turn_around_time = []
    average_turn_around_time = 0
    wait_time.insert(0, 0)
    turn_around_time.insert(0, burst_time[0])

    ''' 
    Computing wait time, average wait time, and average turn around time
    Inserting the results to their respected lists
    '''
    for i in range(1, len(burst_time)):
        wait_time.insert(i, wait_time[i - 1] + burst_time[i - 1])
        turn_around_time.insert(i, wait_time[i] + burst_time[i])
        average_wait_time += wait_time[i]
        average_turn_around_time += turn_around_time[i]
        
    average_wait_time = float(average_wait_time) / num_processes
    average_turn_around_time = float(average_turn_around_time) / num_processes

    ''' 
    Iterate through lists and print out the data
    '''
    print("\n")
    print("Process\t  Burst Time\t  Waiting Time\t  Turn Around Time")
    for i in range(0, num_processes):
        print(str(processes[i]) + "\t\t" + "\t\t" + str(burst_time[i]) + "\t\t" + "\t\t" + str(wait_time[i]) + "\t\t" + "\t\t" + str(turn_around_time[i]))
        print("\n")
    print("Average waiting time is: " + str(average_wait_time))
    print("Average turn around time is: " + str(average_turn_around_time))
