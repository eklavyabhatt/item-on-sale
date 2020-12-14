CREATE TABLE IF NOT EXISTS SHOPUSER (
  userid INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS CATEGORY (
  categoryid INT AUTO_INCREMENT  PRIMARY KEY,
  categoryame VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS ITEM (
  itemid INT AUTO_INCREMENT  PRIMARY KEY,
  categoryid INT,
  categoryame VARCHAR(250),
  itemname VARCHAR(250),
  itemdescription VARCHAR(250),
  isitemonsale VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS RATING (
	ratingid INT AUTO_INCREMENT  PRIMARY KEY,
	userid INT,
	itemid INT,
	rating INT
);

CREATE TABLE IF NOT EXISTS ORDERS (
	userid INT,
	itemid INT
);

CREATE TABLE IF NOT EXISTS WISHLIST (
	userid INT,
	itemid INT
);

CREATE TABLE IF NOT EXISTS HOTDEALS (
	itemid INT
);

CREATE TABLE IF NOT EXISTS RECOMMENDATIONS (
	itemid INT,
	categoryid INT,
	rating INT
);