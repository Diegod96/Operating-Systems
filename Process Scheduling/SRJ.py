

if __name__ == '__main__':

    number_of_processes = int(input('Enter number of processes: '))
    burst_time = [0] * (number_of_processes + 1)
    arrival_time = [0] * (number_of_processes + 1)
    average_burst_time = [0] * (number_of_processes + 1)
    for i in range(number_of_processes):
        average_burst_time[i] = int(input('Enter the burst time for process {} : '.format(i + 1)))
        arrival_time[i] = int(input('Enter the arrival time for process {} : '.format(i + 1)))
        burst_time[i] = [average_burst_time[i], arrival_time[i], i]
    burst_time.pop(-1)

    sum_burst_time = 0
    i = 0
    ll = []
    for i in range(0, sum(average_burst_time)):
        l = [j for j in burst_time if j[1] <= i]
        l.sort(key=lambda x: x[0])

        burst_time[burst_time.index(l[0])][0] -= 1
        for k in burst_time:
            if k[0] == 0:
                t = burst_time.pop(burst_time.index(k))
                ll.append([k, i + 1])

    completion_time = [0] * (number_of_processes + 1)
    turn_around_time = [0] * (number_of_processes + 1)
    wait_time = [0] * (number_of_processes + 1)
    for i in ll:
        completion_time[i[0][2]] = i[1]

    for i in range(len(completion_time)):
        turn_around_time[i] = completion_time[i] - arrival_time[i]
        wait_time[i] = turn_around_time[i] - average_burst_time[i]
    completion_time.pop(-1)
    wait_time.pop(-1)
    turn_around_time.pop(-1)
    average_burst_time.pop(-1)
    arrival_time.pop(-1)
    print('BT\tAT\tCT\tTAT\tWT')
    for i in range(len(completion_time)):
        print("{}\t{}\t{}\t{}\t{}\n".format(average_burst_time[i], arrival_time[i], completion_time[i], turn_around_time[i], wait_time[i]))
    print('Average Waiting Time = ', sum(wait_time) / len(wait_time))
    print('Average Turnaround Time = ', sum(turn_around_time) / len(turn_around_time))