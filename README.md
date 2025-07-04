## SmartCart 
A Java-based supermarket checkout system with inventory tracking, shipping calculations, expiry validation, and customer billing.
### 📂 Project Structure
```
src/
├── main/                                  
│   ├── Main.java                          # Entry point to run and test scenarios
│   └── Supermarket.java                   # The actual market: items, expiry dates & shipping service
├── services/                              
│   └── ShippingService.java               # Sets up shipping service 
├── supermarket/
│   ├── cart/
│   │   └── Cart.java                      # Manages cart content & totals
│   ├── exceptions/                        # Contains Custom exception types
│   ├── people/
│   │   └── Customer.java                  # Supports checkout to finalize purchases
│   └── products/
│       ├── Products.java                  # Abstract base for all available products created within the package
│       └── Shippable.java                 # Interface
```
