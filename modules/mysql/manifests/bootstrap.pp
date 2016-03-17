define mysql::bootstrap($schema, $user = $title, $password) {
    Class['mysql::server'] -> Mysql::Bootstrap[$title]

    exec { "$title-schema":
        unless  => "mysql -uroot $schema",
        command => "mysqladmin -uroot create $schema",
        path    => "/usr/bin/",
    }

    exec { "$title-user":
        unless  => "mysql -u$user -p$password $schema",
        command => "mysql -uroot -e \"GRANT ALL PRIVILEGES ON \
                                    $schema.* TO '$user'@'%' \
                                    IDENTIFIED BY '$password'; \"",
        path    => "/usr/bin/",
        require => Exec["$title-schema"],
    }
}
