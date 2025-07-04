### 📂 Project Structure
```
Src/
├── main/                                  
│   ├── Main.java                          # Entry point to run and test scenarios
│   └── Supermarket.java                   # Initializes the actual market items, expiry dates, and shipping service
├── services/                              
│   └── ShippingService.java               # Sets up shipping service 
├── supermarket/
│   ├── cart/
│   │   └── Cart.java                      # Manages cart content, totals, and shipping weight
│   ├── exceptions/                        # Custom exception types
│   │   ├── EmptyCartException.java
│   │   ├── ExpiredProductException.java
│   │   ├── NotEnoughBalanceException.java
│   │   ├── NotEnoughProductException.java
│   │   └── ProductNotFoundException.java
│   ├── people/
│   │   └── Customer.java                  # Supports checkout() to finalize purchases
│   └── products/
│       ├── Products.java                  # Abstract base for all available products
│       ├── Biscuits.java
│       ├── Cheese.java                    # Implements Shippable
│       ├── Mobile.java
│       ├── MobileScratchCards.java
│       ├── TV.java                        # Implements Shippable
│       └── Shippable.java                 # Interface
```
