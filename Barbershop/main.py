import random
import sys
import time
from threading import Thread, Lock, Event

mutex = Lock()


# Barbershop class
# Initialized with attributes such as the barber object
# As well as the number of seats, time interval for customers to arrive, number of  customers, and the range for the duration of a haircut
class BarberShop:
    waitingCustomers = []
    numberCustomersLeft = 0

    def __init__(self, barber, numberOfSeats, customerIntervalMin, customerIntervalMax, haircutDurationMin,
                 haircutDurationMax):
        self.barber = barber

        print(f"{numCustomers} people are getting a haircut today")
        print(f'BarberShop intialized with {numberOfSeats} seats')
        print(f'Customer min interval {customerIntervalMin}')
        print(f'Customer max interval {customerIntervalMax}')
        print(f'Haircut min duration {haircutDurationMin}')
        print(f'Haircut max duration {haircutDurationMax}')
        print('---------------------------------------')

    # Opens up the barber shop
    def openShop(self):
        print('Barber shop is opening')
        workingThread = Thread(target=self.barberGoToWork)
        workingThread.start()

    # Sets the barber to work
    def barberGoToWork(self):
        while True:
            mutex.acquire()

            # Customers being served after waiting is on a first come first serve basis
            # When going from the waiting state to haircut state, customer is deleted from the waiting list
            if len(self.waitingCustomers) > 0:
                c = self.waitingCustomers[0]
                del self.waitingCustomers[0]
                mutex.release()
                self.barber.cutHair(c)
            else:
                # If there are no customers waiting but there are still more customers that are going to arrive
                if customersList:
                    mutex.release()
                    print('No customers right now, going to sleep.')
                    barber.sleep()
                    print('Barber woke up')
                # Else there is nobody left on the waiting list or customer list so we are done for the day
                else:
                    print('No more customers for today. Time to close up shop.')
                    print('')
                    print('How did we do today?')
                    print(f'Number of customers served today: {barber.customersServed}')
                    print(f'Number of customers who left: {self.numberCustomersLeft}')
                    sys.exit()

    # Handles the scenarios a customer may have when entering
    def enterBarberShop(self, customer):
        mutex.acquire()
        # Barber is busy
        print(f'-> {customer} entered the shop and is looking for a seat')

        # There is no where to sit, so leave
        if len(self.waitingCustomers) == numberOfSeats:
            print(f'Waiting room is full, {customer} has left')
            self.numberCustomersLeft += 1
            mutex.release()
        # There is a seat, so sit and wait for barber to finish
        else:
            print(f'{customer} sat down in the waiting room')
            self.waitingCustomers.append(customer)
            mutex.release()
            barber.wakeUp()


# Initializes a Customer who has a counter to help with the creation of customers
class Customer:

    def __init__(self, numCustomers):
        self.numCustomer = numCustomers

    # Takes in the number of customers and creates a list of them of size numCustomers
    def makeCustomers(self):
        customers = []
        i = self.numCustomer
        while i > 0:
            customers.append(f'Customer #{i}')
            i -= 1
        return customers


# Initializing a Barber with a counter to keep track of the total number of customers served
# Functions to manage sleeping, waking up, and cutting hair
class Barber:
    customersServed = 0
    barberWorkingEvent = Event()

    def sleep(self):
        # Set barber as waiting
        self.barberWorkingEvent.wait()

    def wakeUp(self):
        # Set barber as active
        self.barberWorkingEvent.set()

    def cutHair(self, customer):
        # Set barber as busy
        self.barberWorkingEvent.clear()

        print(f'{customer} is having a haircut')

        randomHairCuttingTime = random.randrange(haircutDurationMin, haircutDurationMax + 1)
        time.sleep(randomHairCuttingTime)
        print(f'{customer} is done')
        self.customersServed += 1


if __name__ == '__main__':

    # Initializing barber object
    barber = Barber()

    # Asking for user input to initialize the barber shop
    numCustomers = input("How many people are getting a haircut today: ")
    numCustomers = int(numCustomers)
    customers = Customer(numCustomers)
    customersList = customers.makeCustomers()

    numberOfSeats = input("How many seats: ")
    numberOfSeats = int(numberOfSeats)

    customerIntervalMin = input("Minimum time interval for a customer shows up: ")
    customerIntervalMin = int(customerIntervalMin)

    customerIntervalMax = input("Maximum time interval for a customer to show up: ")
    customerIntervalMax = int(customerIntervalMax)

    haircutDurationMin = input("Minimum amount of time a haircut should take: ")
    haircutDurationMin = int(haircutDurationMin)

    haircutDurationMax = input("Maximum amount of time a haircut should take: ")
    haircutDurationMax = int(haircutDurationMax)

    barberShop = BarberShop(barber, numberOfSeats, customerIntervalMin, customerIntervalMax, haircutDurationMin,
                            haircutDurationMax)
    barberShop.openShop()

    # Loop that controls the flow of customers
    while len(customersList) > 0:
        customer = customersList.pop()
        barberShop.enterBarberShop(customer)
        customerInterval = random.randrange(customerIntervalMin, customerIntervalMax + 1)
        time.sleep(customerInterval)
