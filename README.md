# item-on-sale
Spring Boot based REST API to fetch recommended list of items that are on sale for a user


Task description:

Write a microservice named "items-on-sale", using Spring boot framework and desired dependency management tool, which returns recommended items list, which are on sale, for a valid user on a shopping website. Before you begin, please consider the requirements below as flexible to your comprehension and assumption. Also note that you can use desired source to retrieve the data.
 
Add an endpoint /recommendations/{userId} to "items-on-sale ". To prepare the recommended items on sale, consider the following:
A. Categories of items the user bought before, consider “my Orders” list, and the user’s rating for these items. The ratings will affect the recommendation list, where the items from higher ranked categories will appear first.
B. The user’s favorite items list categories. “Wish list”
C. The items on sale, from all other categories, which has the highest rankings among all other customers. “Hot deals”
Note that items on sale list only changes once daily.
Secure your service to only allow calls from the website domain “shopping.rbc.com”
Consumers/Users should have valid credentials when calling the microservice or else they will get 403 forbidden error
 
Guidelines Steps:
Create a service
Add an endpoint
Connect to data source
Handle errors / Fail gracefully
Protect the service
Document the API

Solution description:

Developed a Spring Boot based microservice with Maven as dependency management tool and Oracle DB as Data source. Have provided details for H2 as well if incase needed for a quick test.

Provided CORS support for only "shopping.rbc.com" as requested to restrict to a particular domain.

Okta has been used for providing user authentication. Please update details for your own account.

API has been documented with Swagger and OpenAPI 3.0. For images please visit /images folder.

