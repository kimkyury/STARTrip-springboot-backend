export const localsMiddleware = (req, res, next) => {
  res.locals.loggendIn = Boolean(req.session.loggedin);
  res.locals.sitename = "ARDISH";
  res.locals.loggedInUser = req.session.user;
  next();
};
