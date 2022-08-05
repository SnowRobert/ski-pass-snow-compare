## Forecast Your Snow

- Aggregates and displays snow forecasts for several major ski resorts
- Compares upcoming snow totals between the major ski Mega Passes (Epic and IKON)
- Updates daily

## Visit the live webpage:

https://ski-pass-snow-compare-front.vercel.app/

## Visit the front end's repository:

https://github.com/mrhaffner/ski-pass-snow-compare-front

## Purpose:

- Become more proficient with Typescript
- Explore NextJS
- Learn Java (I started learning Java 3 days before starting this project!)
- Explore Object-Oriented Programming (Why I chose to learn Java)

## Design:

This project takes advantage of several free tier services:

- External weather API (rate limited to one request per second, no bulk requests allowed)
- Spring Boot API on Heroku
- PostgreSQL database on Heroku
- Next JS web page on Vercel
- Github Actions webhooks

Github Actions are used to create a daily update pipeline:

1. Github Actions webook wakes up the sleeping Spring Boot API
2. Spring Boot API gets updated forecast information from the weather API
3. Updated forecast information is saved to the PostrgeSQL database
4. Github Actions webook triggers the Next JS app to do a build
5. Next JS app fetches updated data from the Spring Boot API and completes the build

## Built with:

- Java
- Springboot
- PostgreSQL

## Acknowledgements:

- [Weatherbit](https://www.weatherbit.io/) for the weather data.
- Red Stapler for the great tutorial on making a snow effect background.
- Steve Schoger @ HeroPatterns for the excellent background pattern for the mobile footer. I am also a big fan of his book, Refactoring UI.

## Potential improvements:

- Testing
- Proper Documentation
- Better Java style
