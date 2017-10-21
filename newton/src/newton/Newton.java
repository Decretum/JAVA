package newton;

import java.util.function.DoubleFunction; 
	public class Newton { 
		public static void main(String[] args){ 
			// Newton's Approximation to solve cos(x) = x         
			newton( "x^2 = 0", 
					-2, 
					20000, 
					(double x ) -> (x + 2) * (x + 2) * (x + 2) - 2 , 
					(double x ) -> 3 * (x + 2) * (x + 2)) ;     	
			} 
		private static void newton(
				final String equation, 
				final double x0, 	
				final int maxTries, 
				final DoubleFunction<Double> f, 
				final DoubleFunction<Double> dfbydx) 
		 {double x = x0; 
		 int tries = maxTries; 
		 for (;tries > 0; tries--) 
		 { final double y = f.apply(x); 
		 if (Math.abs(y) < 1E-14) 
		 {
			 System.out.println("The solution to "+equation+" is: " + x);                 
			 System.exit(0);             
			 }             
		 x = x - y / dfbydx.apply(x);
		 System.out.println(x);
		 System.exit(0);
		 }     
		 } 
		}
	
