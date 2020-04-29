if __name__ == '__main__':

    burst_time = []
    print("Enter the number of process: ")
    num_processes = int(input())
    print("Enter the burst time of the processes: \n")
    burst_time = list(map(int, input().split()))

    wt = []
    average_wait_time = 0
    tat = []
    average_turn_around_time = 0

    wt.insert(0, 0)
    tat.insert(0, burst_time[0])

    for i in range(1, len(burst_time)):
        wt.insert(i, wt[i - 1] + burst_time[i - 1])
        tat.insert(i, wt[i] + burst_time[i])
        average_wait_time += wt[i]
        average_turn_around_time += tat[i]

    average_wait_time = float(average_wait_time) / num_processes
    average_turn_around_time = float(average_turn_around_time) / num_processes
    print("\n")
    print("Process\t  Burst Time\t  Waiting Time\t  Turn Around Time")

    for i in range(0, num_processes):
        print(str(i) + "\t\t" + "\t\t" + str(burst_time[i]) + "\t\t" + "\t\t" + str(wt[i]) + "\t\t" + "\t\t" + str(tat[i]))
        print("\n")

    print("Average Waiting time is: " + str(average_wait_time))
    print("Average Turn Around Time is: " + str(average_turn_around_time))
