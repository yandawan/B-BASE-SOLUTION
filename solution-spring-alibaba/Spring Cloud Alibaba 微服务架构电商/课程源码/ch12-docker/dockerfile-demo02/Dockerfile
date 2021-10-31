FROM ubuntu

ADD startup.sh /opt

RUN chmod +x /opt/startup.sh

ENTRYPOINT ["/opt/startup.sh", "arg1"]
CMD ["arg2"]
#ENTRYPOINT ["/opt/startup.sh"]
#CMD ["/opt/startup.sh"]
