# ![](http://i.imgur.com/TdcAJHS.png) Simulated Annealing
This program uses the Simulated Annealing algorithm to get a possible solution back to the traveling salesman problem. We first start off with a temperature of `10000` and a cooling rate of `0.00003`. During each iteration, we swap the edges of two pairs of connected cities and determine if the path is shorter. If not, then we use our value function to either accept or deny the new path in hopes of a optimal path later on as the algorithm runs. After each iteration, we lower the temperature by the cooling rate to stop the algorithm after some time.

If the temperature is high, there is a higher probability of accepting a suboptimal path after swapping. This probability decreases as the temperature goes down, which eventually turns into the Hill Climbing algorithm (only accepting paths that are better). We calculate the probability with the following equation:

<p align="center">
<img src="http://i.imgur.com/ogbWsjw.png" />
</p>

where `∆E = currentEnergy−newEnergy` and `T = temperature`. The randomness allows the algorithm to explore various paths and not get stuck in a local extrema.

## ![](http://i.imgur.com/jXO2hN0.png) Usage
You may run the project as is through your terminal or open up the project in your favorite editor (project set up for **Eclipse**) and edit `Main.java` as you see fit. If you want to create a new set of random city configurations then uncomment out the following at the start of `main()`:

```java
System.out.print("Creating cities......");
CityInformation.create(10,  "cities/c010");
CityInformation.create(25,  "cities/c025");
CityInformation.create(50,  "cities/c050");
CityInformation.create(100, "cities/c100");
System.out.println("[DONE]");
```
Other configurations:
+ If you wish to change how the cities are made, then edit `CityInformation.java`. 
+ Inside `main()`, you may also set the temperature and cooling rate.
+ The first `for` loop runs the algorithm on the specified cities. Uncomment/comment out the code to run your configuration.

After running the program, you will see the averages along with with a line graph showing you how the distance went down as the temperature dropped or time passed. It should look similar to the following (ran on twenty five files using 25 cities):

<p align="center">
<img src="http://i.imgur.com/LEBw02A.png" />
</p>

The early cut-off for some of the lines mean that they stayed constant after that point. Adjusting the temperature and/or cooling rate will give you different results. 
