FROM node:14.15.4-alpine
WORKDIR /home/eventapi
COPY . .
RUN yarn && yarn build && yarn doc
EXPOSE 3000
CMD ["sh","-c","yarn start:prod"]