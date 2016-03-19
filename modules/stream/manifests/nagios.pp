class stream::nagios inherits stream {
    include stream::params

    class {"nagios::nagios3":}

    nagios::bootstrap { $stream::params::nagios['user']:
        password  => $stream::params::nagios['password'],
    }

}