class stream::db inherits stream {

    include stream::params

    class {"mysql::server":}

    mysql::bootstrap { $stream::params::db['user']:
        schema    => $stream::params::db['schema'],
        password  => $stream::params::db['password'],
    }

 }