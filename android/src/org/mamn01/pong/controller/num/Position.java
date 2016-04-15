package org.mamn01.pong.controller.num;

/**
 * Created by hampusballdin on 2016-04-12.
 */
public class Position {

		private Velocity velocity;
		private double p;

		public Position(Velocity velocity) {
				this.velocity = velocity;
		}

		public void onVelocityUpdate(double dt) {
				double v = velocity.getValue();
				p += v * dt;
		}

		public void onVelocityUpdatePositive(double dt) {
				double v = velocity.getValue();
				if(v > 0) {
						p += v * dt;
				}

		}
		public void onVelocityUpdateNegative(double dt) {
				double v = velocity.getValue();
				if(v < 0) {
						p += v * dt;
				}
		}

		double getValue() {
				return p;
		}

}
