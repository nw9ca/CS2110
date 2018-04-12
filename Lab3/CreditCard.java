//	To represent the a credit card

public class CreditCard
{
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
	this.owner = newCardholder;
	this.creditLimit = limit;
	this.balance = new Money(0);
	}
	
	//copying the constructor
	CreditCard(CreditCard c1){
		this.balance = c1.balance;
		this.creditLimit = c1.creditLimit;
		this.owner = c1.owner;
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		return this.balance;
		
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		return this.creditLimit;
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		return this.owner.toString();
	}
	
	//Method to make a charge to the credit card, if
	//the credit limit will not be exceded
	public void charge(Money amount)
	{
		Money sum = this.balance.add(amount);
		if(sum.compareTo(this.creditLimit) <= 0){
			this.balance = sum;
		}
		else
			System.out.println("Exceeds credit limit");
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		Money pay = this.balance.subtract(amount);
		this.balance = pay; 
		
	}		
}