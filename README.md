### This is the back end for my Ski Pass Snow Compare project. 

#### Description:

This project compares upcoming snowfall between ski resorts on the IKON and Epic mega passes for the upcoming week.  A free tier weather API was used for upcoming weather data with low daily limits on API usage.  Due to this limitation, the project was structured as follows:
1. An API and PostrgeSQL database hosted on Heroku collects weather data for all resorts early in the morning.
  1. Heroku free tier applications go to sleep after being unusued for 30 minutes.  A scheduled task will not run with a sleeping app.  A Github Action visits the API everyday to wake it up before it is scheduled to collect data.
2. The front end web page is hosted on Vercel and built with their amazing React framework - Next JS.  If the weather data was gathered in real time from Heroku, when a user visited the webpage, there would be long initial loading times as the Heroku API woke up.  Fortunately, Next JS allows us to statically pre-build webpages (which would be faster even with a non-sleeping API).
3. A Github Action triggers a webhook to Vercel to rebuild the webpage every morning after the weather data is collected.
4. It would have been possible to accomplish all of this without the additional API and database, but the data is being stored for later analysis.  Building the API also served as an opportunaity to learn Java and improve my OOP skills.

#### Main technologies and libraries used:

- Java
- Springboot
- PostgreSQL

#### Visit the live webpage:

https://ski-pass-snow-compare-front.vercel.app/

#### Visit the front end's repository:

https://github.com/mrhaffner/ski-pass-snow-compare-front

#### Acknowledgements:

- [Weatherbit](https://www.weatherbit.io/) for the weather data.
- Red Stapler for the great tutorial on making a snow effect background.
- Steve Schoger @ HeroPatterns for the excellent background pattern for the mobile footer. I am also a big fan of his book, Refactoring UI.
