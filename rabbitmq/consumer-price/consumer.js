const amqp = require('amqplib')

const queue = 'PRICE'

amqp.connect({
    hostname:'localhost',
    port:5672,
    username:'admin',
    password:123456
})
.then(connection => {
    connection.createChannel()
    .then(channel => {
        channel.consume(queue, message => 
            console.log(`message: ${message.content.toString()}`))
    }, {noAck: true})
    .catch(e => console.log(e))
})
.catch(e => console.log(e))